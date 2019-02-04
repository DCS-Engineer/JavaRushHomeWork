package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.add(new User());
            javaRush.users.get(0).setFirstName("Adrenaline");
            javaRush.users.get(0).setLastName("Rush");
            javaRush.users.get(0).setBirthDate(new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse("28 July 2016"));
            javaRush.users.get(0).setMale(true);
            javaRush.users.get(0).setCountry(User.Country.OTHER);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for (User temp : users){
                writer.println(temp.getFirstName());
                writer.println(temp.getLastName());
                writer.println(temp.getBirthDate());
                writer.println(temp.isMale());
                writer.println(temp.getCountry().getDisplayedName());
            }
            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int usersSize = Integer.parseInt(reader.readLine());
            for (int i = 0; i < usersSize; i++){
                users.add(new User());
                users.get(i).setFirstName(reader.readLine());
                users.get(i).setLastName(reader.readLine());
                users.get(i).setBirthDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(reader.readLine()));
                users.get(i).setMale(Boolean.parseBoolean(reader.readLine()));
                String country = reader.readLine();
                switch (country){
                    case "Ukraine":
                        users.get(i).setCountry(User.Country.UKRAINE);
                        break;
                    case "Russia": users.get(i).setCountry(User.Country.RUSSIA);
                        break;
                    case "Other":
                        users.get(i).setCountry(User.Country.OTHER);
                        break;
                }
            }
        }
    }
}
