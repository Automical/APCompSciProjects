import java.io.*;
class PressAnyKey 
{
public static void main(String[] args) 
{
try
{
System.out.println("Hello PressAnyKey Example!");
for(int i = 1;i<= 10 ;i++)
{
System.out.println("--------------------------------------");
for(int j =1 ;j<=10;j++)
{
System.out.println( i + " x "+ j + "= " + i*j);
}
if(i>=5)
{
System.out.println("Press Any Key to display next..!");
BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
int ch = stdin.read();
if(ch !=-1)
continue;
else
break;

}
System.out.println("--------------------------------------");
}
}catch(IOException io)
{
System.out.println("ERROR" + io); 
}
}
}
