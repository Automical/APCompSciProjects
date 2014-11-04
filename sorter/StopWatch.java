

public class StopWatch
{
    // instance variables - replace the example below with your own
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    

    /**
     * Constructor for objects of class StopWatch
     */
    public StopWatch()
    {
        reset();
    }

    public void start()
    {
        if (isRunning) return;
        isRunning = true;
        startTime = System.currentTimeMillis();
    }
    
    public void stop()
    {
        if ( ! isRunning ) return;
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
    }
    
    public long getTime()
    {
        if (isRunning)
        {
            long endTime = System.currentTimeMillis();
            elapsedTime = elapsedTime + endTime - startTime;
            startTime=endTime;
        }
        return elapsedTime;
    }
    
    public void reset()
    {
        elapsedTime = 0;
        isRunning = false;
    }
       
}// end of StopWatch Class
