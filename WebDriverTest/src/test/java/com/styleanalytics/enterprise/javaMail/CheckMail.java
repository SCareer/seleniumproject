package com.styleanalytics.enterprise.javaMail;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FromTerm;
import javax.mail.search.SearchTerm;

public class CheckMail {

    public static void check(String host, String storeType, String user,
                             String password)
    {
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("inbox");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it

            SearchTerm sender = new FromTerm(new InternetAddress("matthew.thompson@styleanalytics.com"));
            Message[] messages = emailFolder.search(sender);

            //Message[] messages = emailFolder.getMessages();
            Collections.reverse(Arrays.asList(messages));
            System.out.println("messages.length---" + messages.length);


         /*  for (int i = 0, n = messages.length; i < 2; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
                //message.getFrom().

            }*/

            for (int i = 0, n = messages.length; i < 5; i++) {
                Message indvidualmsg = messages[i];
                System.out.println("Printing individual messages");
                System.out.println("No# " + (i + 1));
                System.out.println("Email Subject: " + indvidualmsg.getSubject());
                System.out.println("Sender: " + indvidualmsg.getFrom()[0]);
                System.out.println("Content: " + indvidualmsg.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "Viswanath.Selvaraj@styleanalytics.com";// change accordingly
        String password = "";// change accordingly

        check(host, mailStoreType, username, password);

    }

}

