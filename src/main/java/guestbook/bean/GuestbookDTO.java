package guestbook.bean;

import java.util.Date;

import lombok.Data;

@Data
public class GuestbookDTO {
	private String seq;
	private String name;
	private String email;
	private String guestSubject;
	private String guestContent;
	private Date logtime;
}
