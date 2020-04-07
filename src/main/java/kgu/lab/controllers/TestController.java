package kgu.lab.controllers;


import kgu.lab.model.Response;
import kgu.lab.model.Test;
import kgu.lab.repositories.RepositoryTest;
import kgu.lab.service.MyService;
import kgu.lab.utils.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class TestController {

    RepositoryTest repository;
    File file = new File("file.txt");
    List<String> list = new ArrayList<String>();
    List<Double> list2 = new ArrayList<Double>();
    MyService myService;

    @Autowired
    public void setRepository(RepositoryTest repository) {
        this.repository = repository;
    }

//    @ResponseBody
    @RequestMapping(value = "/testGet/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<String> testList(@PathVariable String id, HttpServletRequest request) {

        try {
            List<String> testList = new ArrayList<String>();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                testList.add(line);
                System.out.println(line);
            }

            return testList;

        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

//    @ResponseBody
    @RequestMapping(value = "/testPost", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody Test test, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if(test.getText() != null) {
                list.add(test.getText());
                for (String s : list)
                    bufferedWriter.write(s+ "\n");
            }

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (test.getText() != null) {
            try {
                repository.addTest(test.getId(), test.getText());
            } catch (Exception e) {
                error = ErrorEnum.SYSTEM_ERROR;
                return ErrorEnum.createResponse(error);
            }
        }
        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test1", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody double test, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;
            String res = myService.lightning(test);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(res);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            try {
                repository.addTest(String.valueOf(test), String.valueOf(test));
            } catch (Exception e) {
                error = ErrorEnum.SYSTEM_ERROR;
                return ErrorEnum.createResponse(error);
            }

        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test3", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String[] Name, int[] time, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;

        String test = myService.marathon(Name,time);

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test2", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String test, HttpServletRequest request) {
        ErrorEnum error = ErrorEnum.SUCCESS;
        String tmp="";
        test = myService.recurcion(test, tmp);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(tmp, tmp);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test4", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody String text) {
        ErrorEnum error = ErrorEnum.SUCCESS;
        String test = String.valueOf(myService.isPalindrome(text));
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }
    @RequestMapping(value = "/test5", method = RequestMethod.POST, produces = "application/json")
    public Response index(@RequestBody int day) {
        ErrorEnum error = ErrorEnum.SUCCESS;

        int[] tmp = myService.sytki(day);
        String test = tmp[0] + " H, " + tmp[1] + " M, " + tmp[2] + " S";

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            list.add(test);
            for (String s : list)
                bufferedWriter.write(s+ "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            repository.addTest(test, test);
        } catch (Exception e) {
            error = ErrorEnum.SYSTEM_ERROR;
            return ErrorEnum.createResponse(error);
        }

        return ErrorEnum.createResponse(error);
    }

}