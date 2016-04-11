package com.rest;

/**
 * Created by Yauheni_Kuzmianok on 4/10/2016.
 */
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

public class JerseyUpdate
{

    public static void main(String[] args) {

        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("http://localhost:8080/rest/updateUser/ivan");

            String input = "{\"firstName\":\"ivanov\",\"lastName\":\"ivan\",\"email\":\"test@qwe.com\",\"login\":\"ivan2\"}";

            ClientResponse response = webResource.type(MediaType.APPLICATION_XML_TYPE)
                    .post(ClientResponse.class, input);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
