package com.rest; /**
 * Created by Yauheni_Kuzmianok on 4/10/2016.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Path("/")
public class HelloWorldService {
    public static List<User> list = new ArrayList<User>();

    @GET
    @Path("/hello/{param}")
    public Response getMessage(@PathParam("param") String message) {
        String output = "Jersey says " + message;
        return Response.status(200).entity(output).build();
    }
    @POST
    @Path("/addUser")
    @Consumes("application/xml")
    public Response addUser(User user) {
        HelloWorldService.list.add(user);
        return Response.status(200).entity("work").build();
    }

    @POST
    @Path("/updateUser/{login:.+}")
    public Response updateUser(@PathParam("login") String login, String str) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(str, User.class);
        Integer index = null;
        for (int i = 0; i < HelloWorldService.list.size(); i++) {
            if (HelloWorldService.list.get(i).getLogin().equals(login)) {
                index = i;
                break;
            }
        }
        HelloWorldService.list.set(index, user);
        return Response.status(200).entity("work").build();
    }

    @POST
    @Path("/deleteUser/{login:.+}")
    public Response deleteUser(@PathParam("login") String login) throws IOException
    {
        Integer index = null;
        for (int i = 0; i < HelloWorldService.list.size(); i++) {
            if (HelloWorldService.list.get(i).getLogin().equals(login)) {
                index = i;
                break;
            }
        }
        HelloWorldService.list.remove(index.intValue());
        return Response.status(200).entity("work").build();
    }

    @GET
    @Produces({ MediaType.APPLICATION_XML})
    @Path("/getUsers")
    public List<User> getUser() {
        return getUsers();
    }
    @GET
    @Path("/getUsersJson")
    public String getUsersJson() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(getUsers());
    }

    @GET
    @Path("/download/{login}")
    public Response downloadFile(@PathParam("login") String login)
    {
        Integer index = null;
        for (int i = 0; i < HelloWorldService.list.size(); i++) {
            if (HelloWorldService.list.get(i).getLogin().equals(login)) {
                index = i;
                break;
            }
        }
        final String fileName = HelloWorldService.list.get(index.intValue()).getFileName();
        StreamingOutput fileStream =  new StreamingOutput()
        {
            @Override
            public void write(java.io.OutputStream output) throws IOException, WebApplicationException
            {
                try
                {
                    java.nio.file.Path path = Paths.get(fileName);
                    byte[] data = Files.readAllBytes(path);
                    output.write(data);
                    output.flush();
                }
                catch (Exception e)
                {
                    throw new WebApplicationException("File Not Found !!");
                }
            }
        };
        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition","attachment; filename = image.png")
                .build();
    }

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail,
            @FormDataParam("login") String login) {

        String uploadedFileLocation = "d://" + fileDetail.getFileName();

        // save it
        writeToFile(uploadedInputStream, uploadedFileLocation);
        Integer index = null;
        for (int i = 0; i < HelloWorldService.list.size(); i++) {
            if (HelloWorldService.list.get(i).getLogin().equals(login)) {
                index = i;
                break;
            }
        }
        HelloWorldService.list.get(index.intValue()).setFileName(uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();

    }

    private void writeToFile(InputStream uploadedInputStream,
                             String uploadedFileLocation) {

        try {
            OutputStream out = new FileOutputStream(new File(
                    uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private List<User> getUsers()
    {
        return list;
    }
}
