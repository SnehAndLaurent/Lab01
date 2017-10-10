package ex01C;
import org.apache.log4j.*;
public class Log4jBasics
{
	protected static Logger log = Logger.getLogger(Log4jBasics.class);
	public static void main(String[] args)
	{
		log.debug("DEBUG: Cool !");
		log.info("INFO: Cool !");
	}
}

/**Que 1 : In the lo4j.properties, change the level from INFO to DEBUG, what happens? 
//Sol :
	When we change the level from INFO to DEBUG
	it will appear DEBUG in the beginning and got an output as 
		DEBUG: Cool !
		INFO: Cool !
	The INFO level designates informational messages that highlight the progress of the application at coarse-grained level.
	The DEBUG Level designates fine-grained informational events that are most useful to debug an application. 
*/