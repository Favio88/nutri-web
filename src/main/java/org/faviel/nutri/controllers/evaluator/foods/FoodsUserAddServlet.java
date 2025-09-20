package org.faviel.nutri.controllers.evaluator.foods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.faviel.nutri.connections.MSSQLConnection;
import org.faviel.nutri.daos.FoodDaoImpl;
import org.faviel.nutri.helpers.RequestParam;
import org.faviel.nutri.models.Food;
import org.faviel.nutri.models.FoodGroup;
import org.faviel.nutri.models.UnitOfMeasure;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/mode-evaluator/foods-user/add")
public class FoodsUserAddServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FoodsUserAddServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getServletContext().getRequestDispatcher("/mode-evaluator/foods-user-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = RequestParam.getString(req, "name");
        Integer foodGroupId = RequestParam.getInt(req, "food-group-id");
        Double quantity = RequestParam.getDouble(req, "quantity");
        Integer measureId = RequestParam.getInt(req, "measure-id");
        Double kcal = RequestParam.getDouble(req, "kcal");
        Double fatsTot = RequestParam.getDouble(req, "fats-tot");
        Double fatsSat = RequestParam.getDouble(req, "fats-sat");
        Double fatsTrans = RequestParam.getDouble(req, "fats-trans");
        Double cholesterol = RequestParam.getDouble(req, "cholesterol");
        Double carbohydrates = RequestParam.getDouble(req, "carbohydrates");
        Double fiber = RequestParam.getDouble(req, "fiber");
        Double sugars = RequestParam.getDouble(req, "sugars");
        Double protein = RequestParam.getDouble(req, "protein");
        Double water = RequestParam.getDouble(req, "water");
        Double alcohol = RequestParam.getDouble(req, "alcohol");
        Double vitaminA = RequestParam.getDouble(req, "vitamin-a");
        Double vitaminB1 = RequestParam.getDouble(req, "vitamin-b1");
        Double vitaminB2 = RequestParam.getDouble(req, "vitamin-b2");
        Double vitaminB3 = RequestParam.getDouble(req, "vitamin-b3");
        Double vitaminB5 = RequestParam.getDouble(req, "vitamin-b5");
        Double vitaminB6 = RequestParam.getDouble(req, "vitamin-b6");
        Double vitaminB7 = RequestParam.getDouble(req, "vitamin-b7");
        Double vitaminB9 = RequestParam.getDouble(req, "vitamin-b9");
        Double vitaminB12 = RequestParam.getDouble(req, "vitamin-b12");
        Double vitaminC = RequestParam.getDouble(req, "vitamin-c");
        Double vitaminD = RequestParam.getDouble(req, "vitamin-d");
        Double vitaminE = RequestParam.getDouble(req, "vitamin-e");
        Double calcium = RequestParam.getDouble(req, "calcium");
        Double iron = RequestParam.getDouble(req, "iron");
        Double magnesium = RequestParam.getDouble(req, "magnesium");
        Double potassium = RequestParam.getDouble(req, "potassium");
        Double sodium = RequestParam.getDouble(req, "sodium");
        Double zinc = RequestParam.getDouble(req, "zinc");
        Double phosphorus = RequestParam.getDouble(req, "phosphorus");
        Double iodine = RequestParam.getDouble(req, "iodine");
        Double selenium = RequestParam.getDouble(req, "selenium");
        Double fatsMono = RequestParam.getDouble(req, "fats-mono");
        Double fatsPoli = RequestParam.getDouble(req, "fats-poli");
        Double fats12_0 = RequestParam.getDouble(req, "fats-12-0");
        Double fats14_0 = RequestParam.getDouble(req, "fats-14-0");
        Double fats16_0 = RequestParam.getDouble(req, "fats-16-0");
        Double fats18_0 = RequestParam.getDouble(req, "fats-18-0");
        Double fats18_1 = RequestParam.getDouble(req, "fats-18-1");
        Double fats18_2 = RequestParam.getDouble(req, "fats-18-2");
        Double fats18_3 = RequestParam.getDouble(req, "fats-18-3");
        Double fats20_4 = RequestParam.getDouble(req, "fats-20-4");
        Double fats20_5 = RequestParam.getDouble(req, "fats-20-5");
        Double fats22_6 = RequestParam.getDouble(req, "fats-22-6");


        Food food = new Food();
        food.setName(name);

        FoodGroup foodGroup = new FoodGroup();
        foodGroup.setId(foodGroupId);
        food.setFoodGroup(foodGroup);

        food.setQuantity(quantity);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(measureId);
        food.setUnitOfMeasure(unitOfMeasure);

        food.setKcal(kcal);
        food.setFatsTot(fatsTot);
        food.setFatsSat(fatsSat);
        food.setFatsTrans(fatsTrans);
        food.setCholesterol(cholesterol);
        food.setCarbohydrates(carbohydrates);
        food.setFiber(fiber);
        food.setSugars(sugars);
        food.setProtein(protein);
        food.setWater(water);
        food.setAlcohol(alcohol);
        food.setVitaminA(vitaminA);
        food.setVitaminB1(vitaminB1);
        food.setVitaminB2(vitaminB2);
        food.setVitaminB3(vitaminB3);
        food.setVitaminB5(vitaminB5);
        food.setVitaminB6(vitaminB6);
        food.setVitaminB7(vitaminB7);
        food.setVitaminB9(vitaminB9);
        food.setVitaminB12(vitaminB12);
        food.setVitaminC(vitaminC);
        food.setVitaminD(vitaminD);
        food.setVitaminE(vitaminE);
        food.setCalcium(calcium);
        food.setIron(iron);
        food.setMagnesium(magnesium);
        food.setPotassium(potassium);
        food.setSodium(sodium);
        food.setZinc(zinc);
        food.setPhosphorus(phosphorus);
        food.setIodine(iodine);
        food.setSelenium(selenium);
        food.setFatsMono(fatsMono);
        food.setFatsPoli(fatsPoli);
        food.setFats12_0(fats12_0);
        food.setFats14_0(fats14_0);
        food.setFats16_0(fats16_0);
        food.setFats18_0(fats18_0);
        food.setFats18_1(fats18_1);
        food.setFats18_2(fats18_2);
        food.setFats18_3(fats18_3);
        food.setFats20_4(fats20_4);
        food.setFats20_5(fats20_5);
        food.setFats22_6(fats22_6);


        FoodDaoImpl foodDao = new FoodDaoImpl();
        try (Connection conn = MSSQLConnection.getConnection()) {
            foodDao.save(conn, food);
            req.getSession().setAttribute("successMessage","Se ha guardado correctamente");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al guardar el registro", e);
            req.getSession().setAttribute("errorMessage", "Error al guardar el registro");
        }

        resp.sendRedirect(req.getContextPath() + "/mode-evaluator/food-user");
    }
}
