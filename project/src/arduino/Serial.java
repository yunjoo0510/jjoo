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
            //Ŭ���� �̸��� �ĺ��ڷ� ����Ͽ� ��Ʈ ����
            CommPort commPort = portIdentifier.open(this.getClass().getName(),2000);
            
            if ( commPort instanceof SerialPort )
            {
                //��Ʈ ����(��żӵ� ����. �⺻ 9600���� ���)
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);

                //Input,OutputStream ���� ���� �� ����
                InputStream in = serialPort.getInputStream();

                //�б�, ���� ������ �۵�
                (new Thread(new SerialReader(in))).start();

            }
            else
            {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }     
    }

    //������ ����
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
                       System.out.println("������ ���ڿ�: "+ Integer.valueOf(op));
                    }*/
                    else if(op.length()>4){

                        System.out.println("int �� ���ڿ� : "+Integer.valueOf(op.substring(0, 4)));
                        list.add(Integer.valueOf(op.substring(0,4)));
                        op=op.substring(4,op.length());
                        System.out.println("����Ʈ �� ���ڿ� :"+list);

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
                        //1�е��� 30���� �����ϰ� �� �������� �������� �з��� �Ŀ� 
                        //30���� �������� ��հ��� ����, �� ��� �������� �ݿø��ϰ� �ȵ���̵�� ����
                        
                        if(i==Standard_cost)
                        {
                           Level=((Level/Standard_cost))+0.5;
                           Average_level=(int)Level;
                         
                           CO2.insert(Average_level);
                           
                           Level=0;
                           i=0;
                            System.out.println("�Ƶ��̳�� ���۵� ��շ�����:"+Average_level);
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
        (new Serial()).connect("COM3"); //�Է��� ��Ʈ�� ����
    }
    catch ( Exception e )
    {
        // Auto-generated catch block
        e.printStackTrace();
    }

    
	}
}
    