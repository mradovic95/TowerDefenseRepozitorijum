package main_package;

public class MainThread extends Thread
{
	
	/**
	 * Number of frames per second(number of {@link GameWindow#update()} and 
	 * {@link GameWindow#draw()} methods calls.
	 */
	private int fps=30;
	/**
	 * Time when current game frame begins.
	 */
	private long startTime;
	/**
	 * Frame duration in milliseconds(1000/fps).
	 */
	private long targetTime;
	/**
	 * Thread sleep duration.
	 */
	private long waitTime;
	/**
	 *Difference between current system time and frame start time {@link #startTime}
	 */
	private long elapsedTime;
	/**
	 * Game running trigger
	 */
	private boolean running;
	private GameWindow gameWindow;
	
	/**
	 * Class constructor
	 * @param gameWindow game window
	 */
	public MainThread(GameWindow gameWindow) 
	{
		this.gameWindow=gameWindow;
	}
	
	/**
	 * This method call {@link GameWindow#update()} and {@link GameWindow#draw()} method multiple
     * times in second({@link #fps}),calculate how long thread must sleep({@link #waitTime})
     * and call thread.sleep() at the end.
	 */
	@Override
	public void run() 
	{
		running=true;
		targetTime=1000/fps;
		
		while(running)
		{
			
			startTime=System.nanoTime();
			gameWindow.update();
			gameWindow.draw();
			
			elapsedTime=(System.nanoTime()-startTime)/1000000;
			waitTime=targetTime-elapsedTime;
			
			try
			{
			this.sleep(waitTime);
			}
			catch(Exception e)
			{
				//e.printStackTrace();
			}				
		}
			
	}

	/**
	 * @return the fps
	 */
	public int getFps() {
		return fps;
	}

	/**
	 * @param fps the fps to set
	 */
	public void setFps(int fps) {
		this.fps = fps;
	}

	/**
	 * @return the elapsedTime
	 */
	public long getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
	 * @return the running
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * @param running the running to set
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	

	
	

}
