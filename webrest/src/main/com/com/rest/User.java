package com.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Yauheni_Kuzmianok on 4/10/2016.
 */
@XmlRootElement
public class User
{
    String firstName;
    String lastName;
    String email;
    String login;
    String fileName;

    public User(){

    }
    public User(String firstName, String lastName, String email, String login)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
    }

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }
}
