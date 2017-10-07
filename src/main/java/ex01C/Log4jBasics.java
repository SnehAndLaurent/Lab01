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

//Que 1 In the lo4j.properties, change the level from INFO to DEBUG, what happens? 
//Sol When we change the level from INFO to DEBUG it will appear DEBUG in the beginning and got an output as 
//		DEBUG: Cool !
//		INFO: Cool !