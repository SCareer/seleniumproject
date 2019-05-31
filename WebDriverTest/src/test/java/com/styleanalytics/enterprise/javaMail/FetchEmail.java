package com.styleanalytics.enterprise.javaMail;

import java.util.*;
import javax.mail.*;
import javax.mail.search.*;

public class FetchEmail {

    public void searchEmail(String host, String port, String userName,
                            String password, final String keyword, String sender) throws Exception {
        Properties properties = new Properties();

        // server setting
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);

        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",
                String.valueOf(port));

        Session session = Session.getDefaultInstance(properties);

        try {
            // connects to the message store
            Store store = session.getStore("imap");
            store.connect(userName, password);

            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);


            /**
             * Search and Filter Criteria Sender, Unread email, Received Today, Subject
             * **/
            Calendar cal;
            cal = Calendar.getInstance();

            //cal.add(Calendar.DAY_OF_MONTH, -1);  //get yesterday
            Date date = new Date(cal.getTimeInMillis());   //get today date

            //Filter email by today's date
            ReceivedDateTerm receivedDateTerm = new ReceivedDateTerm(ComparisonTerm.EQ,date);
            Message[] foundMessages = folderInbox.search(receivedDateTerm);
            Collections.reverse(Arrays.asList(foundMessages));
            System.out.println(foundMessages.length);

            int mailCount=0;
            for (int i = 0; i < foundMessages.length; i++) {
                if(!foundMessages[i].getFlags().contains(Flags.Flag.SEEN)&&
                        foundMessages[i].getFrom()[0].toString().equalsIgnoreCase(sender)&&
                        foundMessages[i].getSubject().contains(keyword)){

                    Message message = foundMessages[i];
                    String subject = message.getSubject();
                    System.out.println("Found message #" + i + ": " + subject);
                    System.out.println("Success");
                    mailCount ++;
                    }
            }

            // disconnect
            folderInbox.close(false);
            store.close();

            if(mailCount<1){
                throw new Exception("Mail not found");
            }else if(mailCount>1){
                throw new Exception("Too many emails Found: "+mailCount);
            }
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store.");
            ex.printStackTrace();
        }
    }

    /**
     * Test this program with a Gmail's account
     */
    public static void main(String[] args) throws Exception {
        String host = "imap.gmail.com";
        String port = "993";
        String userName = "Viswanath.Selvaraj@styleanalytics.com";
        String password = "";
        FetchEmail searcher = new FetchEmail();
        String keyword = "Style Research";
        String sender = "support@styleresearch.com";
        searcher.searchEmail(host, port, userName, password, keyword,sender);
    }

}

