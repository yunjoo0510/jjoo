package arduino;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import dao.CO2Dao;

public class Serial {
   

   public static byte[] buffer = new byte[1024];
   public static int len = 0;
   public static String op = new String(buffer,0,len);

    public Serial()
    { 
        super();
    }
    
    void connect ( String COM3 ) throws Exception
    {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(COM3);
        if ( portIdentifier.isCurrentlyOwned() )
        {
            System.out.println("Error: Port is currently in use");
        }
        else
        {
            //클래스 이름을 식별자로 사용하여 포트 오픈
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                //포트 설정(통신속도 설정. 기본 9600으로 사용)
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

                //Input,OutputStream 버퍼 생성 후 오픈
                InputStream in = serialPort.getInputStream();

                //읽기, 쓰기 쓰레드 작동
                (new Thread(new SerialReader(in))).start();

            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }

    //데이터 수신
    public static class SerialReader implements Runnable 
    {
        InputStream in;
        String op ="";
        double Level;
        int Average_level;;
        double Ready_level;;
        int Standard_cost=10;
        int i=0;
        List<Integer> list=new ArrayList<Integer>();
        
        public SerialReader ( InputStream in )
        {
            this.in = in;
        }

        public void run ()
        {

            CO2Dao CO2=new CO2Dao();
            byte[] buffer = new byte[1024];
            //int len = -1;
            try
            {
                while( ( len = this.in.read(buffer)) > -1 )
                {
                   if((new String(buffer,0,len).length())!=0){
                     op =op+ new String(buffer,0,len);
                   }
                    if("".equals(op))
                    {
                    }
                   /* else if(op.length()!=4){
                    //   op+=op;
                       System.out.println("비정상 문자열: "+ Integer.valueOf(op));
                    }*/
                    else if(op.length()>4){

                        System.out.println("int 값 문자열 : "+Integer.valueOf(op.substring(0, 4)));
                        list.add(Integer.valueOf(op.substring(0,4)));
                        op=op.substring(4,op.length());
                        System.out.println("리스트 값 문자열 :"+list);

                        if(0< list.get(i) && 1500>=list.get(i))
                        {
                           Level+= 1; 
                        
                        }else if(1500< list.get(i) && 1700>=list.get(i))
                        {
                              Level+=2;
                           
                        }else if(1700< list.get(i) && 2200>=list.get(i))
                        {
                              Level+=3;
                           
                        }else if(2200< list.get(i) && 2700>=list.get(i))
                        {
                              Level+=4;
                        
                        }else if(2700< list.get(i) && 3200>=list.get(i))
                        {
                              Level+=5;
                           
                        }else if(3200< list.get(i) )
                        {
                              Level+=6;
                        }
                        i+=1;
                       System.out.println(i);
                       System.out.println(Level);
                        //1분동안 30번을 측정하고 각 측정값을 레벨별로 분류한 후에 
                        //30개의 레벨들의 평균값을 내고, 그 평균 레벨값을 반올림하고 안드로이드로 전송
                        
                        if(i==Standard_cost)
                        {
                           Level=((Level/Standard_cost))+0.5;
                           Average_level=(int)Level;
                         
                           CO2.insert(Average_level);
                           
                           Level=0;
                           i=0;
                            System.out.println("아두이노로 전송될 평균레벨값:"+Average_level);
                            list.clear();

                        }

                    }
                }

            }
            catch ( IOException e )
            {
                e.printStackTrace();
            }            
        }

    }


public static void main (String[] args)
{      
    try
    {
        (new Serial()).connect("COM3"); //입력한 포트로 연결
    }
    catch ( Exception e )
    {
        // Auto-generated catch block
        e.printStackTrace();
    }

    
	}
}
    