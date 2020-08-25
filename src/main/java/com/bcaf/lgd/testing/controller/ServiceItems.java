package com.bcaf.lgd.testing.controller;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ServiceItems {

    private Connection conn;
    final String INSERT_ITEMS = "INSERT INTO items (item_name, item_type, description, price, stock, created_date, updated_date) VALUES (?,?,?,?,?,?,?)";
    final String UPDATE_ITEMS = "UPDATE items set price=?, updated_date=? WHERE item_name=?";
    final String DELETE_ITEMS = "DELETE FROM items WHERE item_name=?";
//    final String SELECT_ITEMS = "SELECT * FROM items";
    final String SELECT_ITEMS = "SELECT _id,item_name,item_type,description,price,stock,updated_date FROM items";

    //connection always as a constructor
    public ServiceItems() {
        conn = AdapterJDBC.getConnection();
    }

//    public static void main(String[] args) {
//        ServiceItems si = new ServiceItems();
////        si.doInsertItems();
////        si.doUpdateItems();
////        si.doDeleteItems();
//        si.doSelectItems();
//    }

    public int doInsertItems(String name, int type, String desc, double price, int stock) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ITEMS);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, type);
            preparedStatement.setString(3, desc);
            preparedStatement.setDouble(4, price);
            preparedStatement.setInt(5, stock);
            preparedStatement.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            int row = preparedStatement.executeUpdate();
            preparedStatement.close();
            return row;
            //rows affected
//            System.out.println(row); //1
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int doUpdateItems(items updateItem) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ITEMS);
            preparedStatement.setDouble(1, updateItem.getPrice());
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(3, updateItem.getName());

            int row = preparedStatement.executeUpdate();
            return row;
            // rows affected
//            System.out.println(row);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int doDeleteItems(items deleteItem) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ITEMS);
            preparedStatement.setString(1, deleteItem.getName());

            int row = preparedStatement.executeUpdate();
            return row;
            // rows affected
//            System.out.println(row);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<items> doSelectItems() {

        List<items> selectItems = new LinkedList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ITEMS);

            ResultSet row = preparedStatement.executeQuery();
            while (row.next()) {

                int id = row.getInt("_id");
                String name = row.getString("item_name");
                int type = row.getInt("item_type");
                String desc = row.getString("description");
                double price = row.getDouble("price");
                int stock = row.getInt("stock");
                Timestamp updatedDate = row.getTimestamp("updated_date");

                items itm = new items();

                itm.setId(id);
                itm.setName(name);
                itm.setType(type);
                itm.setDesc(desc);
                itm.setPrice(price);
                itm.setStock(stock);
//                itm.setCreatedDate(createdDate);
                itm.setUpdatedDate(updatedDate);
                selectItems.add(itm);

//                System.out.println(itm.getId()+ " | " + itm.getName() + " | " + itm.getType() + " | " + itm.getDesc() + " | " + itm.getPrice().doubleValue() + " | " + itm.getStock() + " | " + itm.getCreatedDate() + " | " + itm.getUpdatedDate());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectItems;
    }
}


