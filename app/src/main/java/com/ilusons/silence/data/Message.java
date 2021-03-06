package com.ilusons.silence.data;

import com.google.firebase.database.DataSnapshot;

/***
 * Java Object mapping of a single message data.
 */
public class Message {

	public String Id;
	public String SenderId;
	public String ReceiverId;
	public String Content;
	public long Timestamp;

	public Message() {
		Timestamp = System.currentTimeMillis();
	}

	@Override
	public boolean equals(Object obj) {
		Message other = (Message) obj;

		if (other == null)
			return false;

		if (Id.equals(other.Id))
			return true;

		if (Long.compare(Timestamp, other.Timestamp) == 0)
			return true;

		return false;
	}

	/***
	 * Converts JSON data to Java Object.
	 * @param data
	 * @return
	 */
	public static Message createFromData(DataSnapshot data) {
		Message m = new Message();

		try {
			m.Id = data.getKey();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			m.SenderId = (String) data.child(DB.KEY_MESSAGES_SENDER_ID).getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			m.ReceiverId = (String) data.child(DB.KEY_MESSAGES_RECEIVER_ID).getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			m.Content = (String) data.child(DB.KEY_MESSAGES_CONTENT).getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			m.Timestamp = (long) data.child(DB.KEY_MESSAGES_TIMESTAMP).getValue();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}

}
