package co.prjt.own.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO {
	private MessageType type;
	private String content;
	private String sender;

	public enum MessageType{
		CHAT,
		JOIN,
		LEAVE
	}
}

