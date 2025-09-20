package org.faviel.nutri.daos;

import org.faviel.nutri.helpers.PreparedStmtParam;
import org.faviel.nutri.models.Food;
import org.faviel.nutri.models.FoodGroup;
import org.faviel.nutri.models.UnitOfMeasure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements IDAO<Food> {

    @Override
    public List<Food> getAllIncludingInactive(Connection conn) throws SQLException {
        List<Food> foods = new ArrayList<>();
        String sql = "SELECT * FROM Foods f " +
                "INNER JOIN FoodGroups fg ON f.FGRP_Id = fg.FGRP_Id " +
                "INNER JOIN UnitOfMeasures um ON f.UNIM_Id = um.UNIM_Id";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Food food = mapFood(rs);

                foods.add(food);
            }
        }
        return foods;
    }

    @Override
    public List<Food> getAllActive(Connection conn) throws SQLException {
        List<Food> foods = new ArrayList<>();
        String sql = "SELECT * FROM Foods f " +
                "INNER JOIN FoodGroups fg ON f.FGRP_Id = fg.FGRP_Id " +
                "INNER JOIN UnitOfMeasures um ON f.UNIM_Id = um.UNIM_Id " +
                "WHERE f.FOOD_Active=1";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Food food = mapFood(rs);

                foods.add(food);
            }
        }
        return foods;
    }

    @Override
    public Food getById(Connection conn, Integer id) throws SQLException {
        Food food = null;
        String sql = "SELECT * FROM Foods f " +
                "INNER JOIN FoodGroups fg ON f.FGRP_Id = fg.FGRP_Id " +
                "INNER JOIN UnitOfMeasures um ON f.UNIM_Id = um.UNIM_Id " +
                "WHERE FOOD_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setInt(stmt, 1, id);

            ResultSet rs = stmt.executeQuery();
            if   (rs.next()) {
                food = mapFood(rs);
            }
            rs.close();
        }
        return food;
    }

    @Override
    public void save(Connection conn, Food food) throws SQLException {
        String sql = "INSERT INTO Foods(" +
                "FOOD_Name, FGRP_Id, FOOD_Quantity, UNIM_Id, FOOD_Kcal, " +
                "FOOD_Fats_Tot, FOOD_Fats_Sat, FOOD_Fats_Trans, FOOD_Cholesterol, " +
                "FOOD_Carbohydrates, FOOD_Fiber, FOOD_Sugars, FOOD_Protein, FOOD_Water, FOOD_Alcohol, " +
                "FOOD_Vitamin_A, FOOD_Vitamin_B1, FOOD_Vitamin_B2, FOOD_Vitamin_B3, FOOD_Vitamin_B5, " +
                "FOOD_Vitamin_B6, FOOD_Vitamin_B7, FOOD_Vitamin_B9, FOOD_Vitamin_B12, " +
                "FOOD_Vitamin_C, FOOD_Vitamin_D, FOOD_Vitamin_E, " +
                "FOOD_Calcium, FOOD_Iron, FOOD_Magnesium, FOOD_Potassium, FOOD_Sodium, " +
                "FOOD_Zinc, FOOD_Phosphorus, FOOD_Iodine, FOOD_Selenium, " +
                "FOOD_Fats_Mono, FOOD_Fats_Poli, FOOD_Fats_12_0, FOOD_Fats_14_0, FOOD_Fats_16_0, " +
                "FOOD_Fats_18_0, FOOD_Fats_18_1, FOOD_Fats_18_2, FOOD_Fats_18_3, FOOD_Fats_20_4, " +
                "FOOD_Fats_20_5, FOOD_Fats_22_6)" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setString(stmt, 1, food.getName());
            PreparedStmtParam.setInt(stmt, 2, food.getFoodGroup().getId());
            PreparedStmtParam.setDouble(stmt, 3, food.getQuantity());
            PreparedStmtParam.setInt(stmt, 4, food.getUnitOfMeasure().getId());
            PreparedStmtParam.setDouble(stmt, 5, food.getKcal());
            PreparedStmtParam.setDouble(stmt, 6, food.getFatsTot());
            PreparedStmtParam.setDouble(stmt, 7, food.getFatsSat());
            PreparedStmtParam.setDouble(stmt, 8, food.getFatsTrans());
            PreparedStmtParam.setDouble(stmt, 9, food.getCholesterol());
            PreparedStmtParam.setDouble(stmt, 10, food.getCarbohydrates());
            PreparedStmtParam.setDouble(stmt, 11, food.getFiber());
            PreparedStmtParam.setDouble(stmt, 12, food.getSugars());
            PreparedStmtParam.setDouble(stmt, 13, food.getProtein());
            PreparedStmtParam.setDouble(stmt, 14, food.getWater());
            PreparedStmtParam.setDouble(stmt, 15, food.getAlcohol());
            PreparedStmtParam.setDouble(stmt, 16, food.getVitaminA());
            PreparedStmtParam.setDouble(stmt, 17, food.getVitaminB1());
            PreparedStmtParam.setDouble(stmt, 18, food.getVitaminB2());
            PreparedStmtParam.setDouble(stmt, 19, food.getVitaminB3());
            PreparedStmtParam.setDouble(stmt, 20, food.getVitaminB5());
            PreparedStmtParam.setDouble(stmt, 21, food.getVitaminB6());
            PreparedStmtParam.setDouble(stmt, 22, food.getVitaminB7());
            PreparedStmtParam.setDouble(stmt, 23, food.getVitaminB9());
            PreparedStmtParam.setDouble(stmt, 24, food.getVitaminB12());
            PreparedStmtParam.setDouble(stmt, 25, food.getVitaminC());
            PreparedStmtParam.setDouble(stmt, 26, food.getVitaminD());
            PreparedStmtParam.setDouble(stmt, 27, food.getVitaminE());
            PreparedStmtParam.setDouble(stmt, 28, food.getCalcium());
            PreparedStmtParam.setDouble(stmt, 29, food.getIron());
            PreparedStmtParam.setDouble(stmt, 30, food.getMagnesium());
            PreparedStmtParam.setDouble(stmt, 31, food.getPotassium());
            PreparedStmtParam.setDouble(stmt, 32, food.getSodium());
            PreparedStmtParam.setDouble(stmt, 33, food.getZinc());
            PreparedStmtParam.setDouble(stmt, 34, food.getPhosphorus());
            PreparedStmtParam.setDouble(stmt, 35, food.getIodine());
            PreparedStmtParam.setDouble(stmt, 36, food.getSelenium());
            PreparedStmtParam.setDouble(stmt, 37, food.getFatsMono());
            PreparedStmtParam.setDouble(stmt, 38, food.getFatsPoli());
            PreparedStmtParam.setDouble(stmt, 39, food.getFats12_0());
            PreparedStmtParam.setDouble(stmt, 40, food.getFats14_0());
            PreparedStmtParam.setDouble(stmt, 41, food.getFats16_0());
            PreparedStmtParam.setDouble(stmt, 42, food.getFats18_0());
            PreparedStmtParam.setDouble(stmt, 43, food.getFats18_1());
            PreparedStmtParam.setDouble(stmt, 44, food.getFats18_2());
            PreparedStmtParam.setDouble(stmt, 45, food.getFats18_3());
            PreparedStmtParam.setDouble(stmt, 46, food.getFats20_4());
            PreparedStmtParam.setDouble(stmt, 47, food.getFats20_5());
            PreparedStmtParam.setDouble(stmt, 48, food.getFats22_6());

            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Connection conn, Food food) throws SQLException {
        String sql = "UPDATE Foods SET " +
                "FOOD_Name=?, FGRP_Id=?, FOOD_Quantity=?, UNIM_Id=?, FOOD_Kcal=?, " +
                "FOOD_Fats_Tot=?, FOOD_Fats_Sat=?, FOOD_Fats_Trans=?, FOOD_Cholesterol=?, " +
                "FOOD_Carbohydrates=?, FOOD_Fiber=?, FOOD_Sugars=?, FOOD_Protein=?, FOOD_Water=?, FOOD_Alcohol=?, " +
                "FOOD_Vitamin_A=?, FOOD_Vitamin_B1=?, FOOD_Vitamin_B2=?, FOOD_Vitamin_B3=?, FOOD_Vitamin_B5=?, " +
                "FOOD_Vitamin_B6=?, FOOD_Vitamin_B7=?, FOOD_Vitamin_B9=?, FOOD_Vitamin_B12=?, " +
                "FOOD_Vitamin_C=?, FOOD_Vitamin_D=?, FOOD_Vitamin_E=?, " +
                "FOOD_Calcium=?, FOOD_Iron=?, FOOD_Magnesium=?, FOOD_Potassium=?, FOOD_Sodium=?, " +
                "FOOD_Zinc=?, FOOD_Phosphorus=?, FOOD_Iodine=?, FOOD_Selenium=?, " +
                "FOOD_Fats_Mono=?, FOOD_Fats_Poli=?, FOOD_Fats_12_0=?, FOOD_Fats_14_0=?, FOOD_Fats_16_0=?, " +
                "FOOD_Fats_18_0=?, FOOD_Fats_18_1=?, FOOD_Fats_18_2=?, FOOD_Fats_18_3=?, FOOD_Fats_20_4=?, " +
                "FOOD_Fats_20_5=?, FOOD_Fats_22_6=? " +
                "WHERE FOOD_Id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setString(stmt, 1, food.getName());
            PreparedStmtParam.setInt(stmt, 2, food.getFoodGroup().getId());
            PreparedStmtParam.setDouble(stmt, 3, food.getQuantity());
            PreparedStmtParam.setInt(stmt, 4, food.getUnitOfMeasure().getId());
            PreparedStmtParam.setDouble(stmt, 5, food.getKcal());
            PreparedStmtParam.setDouble(stmt, 6, food.getFatsTot());
            PreparedStmtParam.setDouble(stmt, 7, food.getFatsSat());
            PreparedStmtParam.setDouble(stmt, 8, food.getFatsTrans());
            PreparedStmtParam.setDouble(stmt, 9, food.getCholesterol());
            PreparedStmtParam.setDouble(stmt, 10, food.getCarbohydrates());
            PreparedStmtParam.setDouble(stmt, 11, food.getFiber());
            PreparedStmtParam.setDouble(stmt, 12, food.getSugars());
            PreparedStmtParam.setDouble(stmt, 13, food.getProtein());
            PreparedStmtParam.setDouble(stmt, 14, food.getWater());
            PreparedStmtParam.setDouble(stmt, 15, food.getAlcohol());
            PreparedStmtParam.setDouble(stmt, 16, food.getVitaminA());
            PreparedStmtParam.setDouble(stmt, 17, food.getVitaminB1());
            PreparedStmtParam.setDouble(stmt, 18, food.getVitaminB2());
            PreparedStmtParam.setDouble(stmt, 19, food.getVitaminB3());
            PreparedStmtParam.setDouble(stmt, 20, food.getVitaminB5());
            PreparedStmtParam.setDouble(stmt, 21, food.getVitaminB6());
            PreparedStmtParam.setDouble(stmt, 22, food.getVitaminB7());
            PreparedStmtParam.setDouble(stmt, 23, food.getVitaminB9());
            PreparedStmtParam.setDouble(stmt, 24, food.getVitaminB12());
            PreparedStmtParam.setDouble(stmt, 25, food.getVitaminC());
            PreparedStmtParam.setDouble(stmt, 26, food.getVitaminD());
            PreparedStmtParam.setDouble(stmt, 27, food.getVitaminE());
            PreparedStmtParam.setDouble(stmt, 28, food.getCalcium());
            PreparedStmtParam.setDouble(stmt, 29, food.getIron());
            PreparedStmtParam.setDouble(stmt, 30, food.getMagnesium());
            PreparedStmtParam.setDouble(stmt, 31, food.getPotassium());
            PreparedStmtParam.setDouble(stmt, 32, food.getSodium());
            PreparedStmtParam.setDouble(stmt, 33, food.getZinc());
            PreparedStmtParam.setDouble(stmt, 34, food.getPhosphorus());
            PreparedStmtParam.setDouble(stmt, 35, food.getIodine());
            PreparedStmtParam.setDouble(stmt, 36, food.getSelenium());
            PreparedStmtParam.setDouble(stmt, 37, food.getFatsMono());
            PreparedStmtParam.setDouble(stmt, 38, food.getFatsPoli());
            PreparedStmtParam.setDouble(stmt, 39, food.getFats12_0());
            PreparedStmtParam.setDouble(stmt, 40, food.getFats14_0());
            PreparedStmtParam.setDouble(stmt, 41, food.getFats16_0());
            PreparedStmtParam.setDouble(stmt, 42, food.getFats18_0());
            PreparedStmtParam.setDouble(stmt, 43, food.getFats18_1());
            PreparedStmtParam.setDouble(stmt, 44, food.getFats18_2());
            PreparedStmtParam.setDouble(stmt, 45, food.getFats18_3());
            PreparedStmtParam.setDouble(stmt, 46, food.getFats20_4());
            PreparedStmtParam.setDouble(stmt, 47, food.getFats20_5());
            PreparedStmtParam.setDouble(stmt, 48, food.getFats22_6());
            PreparedStmtParam.setInt(stmt, 49, food.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM Foods " +
                "WHERE FOOD_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setInt(stmt, 1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void softDelete(Connection conn, Integer id) throws SQLException {
        String sql = "UPDATE Foods SET " +
                "FOOD_Active=0 " +
                "WHERE FOOD_Id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            PreparedStmtParam.setInt(stmt, 1, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public List<Food> search(Connection conn, String value) throws SQLException {
        return List.of();
    }

    @Override
    public List<Food> find(Connection conn, String fieldName, Object value) throws SQLException {
        return List.of();
    }

    @Override
    public Food findFirst(Connection conn, String fieldName, Object value) throws SQLException {
        return null;
    }

    private Food mapFood(ResultSet rs) throws SQLException {
        Food food = new Food();
        food.setId(rs.getInt("FOOD_Id"));
        food.setName(rs.getString("FOOD_Name"));

        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(rs.getInt("FGRP_Id"));
        foodGroup.setName(rs.getString("FGRP_Name"));
        food.setFoodGroup(foodGroup);

        food.setQuantity(rs.getDouble("FOOD_Quantity"));

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(rs.getInt("UNIM_Id"));
        unitOfMeasure.setName(rs.getString("UNIM_Name"));
        food.setUnitOfMeasure(unitOfMeasure);

        food.setKcal(rs.getDouble("FOOD_Kcal"));
        food.setFatsTot(rs.getDouble("FOOD_Fats_Tot"));
        food.setFatsSat(rs.getDouble("FOOD_Fats_Sat"));
        food.setFatsTrans(rs.getDouble("FOOD_Fats_Trans"));
        food.setCholesterol(rs.getDouble("FOOD_Cholesterol"));
        food.setCarbohydrates(rs.getDouble("FOOD_Carbohydrates"));
        food.setFiber(rs.getDouble("FOOD_Fiber"));
        food.setSugars(rs.getDouble("FOOD_Sugars"));
        food.setProtein(rs.getDouble("FOOD_Protein"));
        food.setWater(rs.getDouble("FOOD_Water"));
        food.setAlcohol(rs.getDouble("FOOD_Alcohol"));
        food.setVitaminA(rs.getDouble("FOOD_Vitamin_A"));
        food.setVitaminB1(rs.getDouble("FOOD_Vitamin_B1"));
        food.setVitaminB2(rs.getDouble("FOOD_Vitamin_B2"));
        food.setVitaminB3(rs.getDouble("FOOD_Vitamin_B3"));
        food.setVitaminB5(rs.getDouble("FOOD_Vitamin_B5"));
        food.setVitaminB6(rs.getDouble("FOOD_Vitamin_B6"));
        food.setVitaminB7(rs.getDouble("FOOD_Vitamin_B7"));
        food.setVitaminB9(rs.getDouble("FOOD_Vitamin_B9"));
        food.setVitaminB12(rs.getDouble("FOOD_Vitamin_B12"));
        food.setVitaminC(rs.getDouble("FOOD_Vitamin_C"));
        food.setVitaminD(rs.getDouble("FOOD_Vitamin_D"));
        food.setVitaminE(rs.getDouble("FOOD_Vitamin_E"));
        food.setCalcium(rs.getDouble("FOOD_Calcium"));
        food.setIron(rs.getDouble("FOOD_Iron"));
        food.setMagnesium(rs.getDouble("FOOD_Magnesium"));
        food.setPotassium(rs.getDouble("FOOD_Potassium"));
        food.setSodium(rs.getDouble("FOOD_Sodium"));
        food.setZinc(rs.getDouble("FOOD_Zinc"));
        food.setPhosphorus(rs.getDouble("FOOD_Phosphorus"));
        food.setIodine(rs.getDouble("FOOD_Iodine"));
        food.setSelenium(rs.getDouble("FOOD_Selenium"));
        food.setFatsMono(rs.getDouble("FOOD_Fats_Mono"));
        food.setFatsPoli(rs.getDouble("FOOD_Fats_Poli"));
        food.setFats12_0(rs.getDouble("FOOD_Fats_12_0"));
        food.setFats14_0(rs.getDouble("FOOD_Fats_14_0"));
        food.setFats16_0(rs.getDouble("FOOD_Fats_16_0"));
        food.setFats18_0(rs.getDouble("FOOD_Fats_18_0"));
        food.setFats18_1(rs.getDouble("FOOD_Fats_18_1"));
        food.setFats18_2(rs.getDouble("FOOD_Fats_18_2"));
        food.setFats18_3(rs.getDouble("FOOD_Fats_18_3"));
        food.setFats20_4(rs.getDouble("FOOD_Fats_20_4"));
        food.setFats20_5(rs.getDouble("FOOD_Fats_20_5"));
        food.setFats22_6(rs.getDouble("FOOD_Fats_22_6"));

        return food;
    }
}
