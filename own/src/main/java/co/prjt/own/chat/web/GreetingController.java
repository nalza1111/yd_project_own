package co.prjt.own.chat.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

  @Autowired
  private SimpMessagingTemplate template;
	
  
//  @MessageMapping("/hello")
//  @SendTo("/topic/greetings")
//  public Greeting greeting(HelloMessage message) throws Exception {
//    Thread.sleep(1000); // simulated delay
//    return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
//  }
  
  
	/*
	 * @MessageMapping("/hello") public void greeting(HelloMessage message) throws
	 * Exception { Thread.sleep(1000); // simulated delay
	 * template.convertAndSend("/topic/greetings/" + message.getRoomno(), message);
	 * }
	 */
}