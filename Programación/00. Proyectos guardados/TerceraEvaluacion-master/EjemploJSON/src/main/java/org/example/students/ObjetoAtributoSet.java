package org.example.students;
import lombok.extern.log4j.Log4j2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @author Ramesh Fadatare
 */
@Log4j2
public class ObjetoAtributoSet {


        public static void main(String[] args) {
            Configuracion config = new Configuracion();
            deserializeUserObject();
            serializeStudentObject();
            List<Student> lista = new ArrayList<>();
            lista.add(createStudent());
            lista.add(createStudent());
            saveEstudiantes(lista, config.loadPathProperties());
            lista.clear();
            System.out.println(lista);
            lista = loadStudents(config.loadPathProperties());
            System.out.println(lista);
        }

        private static void deserializeUserObject() {
            Gson gson = new Gson();
            String jsonStr = "{\r\n" +
                    "  \"studentId\": 1000,\r\n" +
                    "  \"studentName\": \"Ramesh\",\r\n" +
                    "  \"studentPhoneNumbers\": [\r\n" +
                    "    {\r\n" +
                    "      \"phoneId\": 100,\r\n" +
                    "      \"phoneType\": \"Mobile Phone\",\r\n" +
                    "      \"phoneNumber\": \"1234567890\"\r\n" +
                    "    },\r\n" +
                    "    {\r\n" +
                    "      \"phoneId\": 101,\r\n" +
                    "      \"phoneType\": \"Landline Phone\",\r\n" +
                    "      \"phoneNumber\": \"2222 3333 44\"\r\n" +
                    "    }\r\n" +
                    "  ]\r\n" +
                    "}";

            Student student = gson.fromJson(jsonStr, Student.class);
            try {
                PrintWriter pw = new PrintWriter("data/student.json");
                System.out.println(student.toString());
                pw.println(student);
                pw.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        private static void serializeStudentObject() {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Student student = createStudent();
            String jsonStr = gson.toJson(student);
            try {
                PrintWriter pw = new PrintWriter("data/student.json");
                System.out.println(student);
                pw.println(jsonStr);
                pw.close();
            } catch (FileNotFoundException e) {
                log.error(e.getMessage(), e);
            }
            System.out.println(jsonStr);
        }

        private static Student createStudent() {
            int id = (int)(Math.random()*11+1);
            Student student = new Student(id,"Student"+id);
            Set<Phone> phones = new HashSet<>();
            Phone phone = new Phone(100,"MobilePhone","1234567890");
            phones.add(phone);
            Phone phone1 = new Phone(101,"LandLinePhone","0987654321");
            phones.add(phone1);
            student.setStudentPhoneNumbers(phones);
            return student;
        }
    public static List<Student> loadStudents(String file) { //leer
        Type userListType = new TypeToken<List<Student>>() {}.getType();

        List<Student> estudiantes = new ArrayList<>();
        try (FileReader fr = new FileReader(file)) {
            estudiantes = new Gson().fromJson(fr, userListType);
        } catch (FileNotFoundException e) {
            //log.error(e.getMessage(), e);
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (estudiantes == null){
            estudiantes = new ArrayList<>() {
            };
        }
        return estudiantes;
    }

    public static boolean saveEstudiantes(List<Student> estudiantes, String file) { //escribir
        //PrintWriter o FileWriter
        try (PrintWriter pw = new PrintWriter(file)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            gson.toJson(estudiantes,pw);
            //new Gson().toJson(estudiantes, pw); //sin pretty (pero también funciona lo único que 1 línea...)
        } catch (IOException e) {
            //log.error(e.getMessage(), e);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    }




