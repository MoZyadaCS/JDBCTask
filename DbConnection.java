package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbConnection {
    private static String url = "jdbc:mysql://localhost:3306/iti";
    private static String user ="root";
    private static String password = "";

    private static BasicDataSource basicDataSource;
    public static BasicDataSource getBasicDataSource(){
        if(basicDataSource == null){
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            dataSource.setMinIdle(10);
            dataSource.setMaxIdle(50);

            basicDataSource = dataSource;
        }
        return basicDataSource;
    }
}
