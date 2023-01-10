/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suzimen.mathutil.core;

//import static là dành riêng cho những hàm static
//gọi hàm mà bỏ qua tên class
import static com.suzimen.mathutil.core.MathUtil.getFactorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author asus
 */
public class MathUtilTest {
    
    // DDT : tách data ra khỏi câu lệnh kiểm thử tham số hóa data này
    //vào trong câu lệnh kiểm thử
    
    //chuẩn bị bộ data
    public static Object[][] initData(){
        return new Integer[][]{
                                {1,1},
                                {2,2},
                                {5,120},
                                {6,720},
        };
    }
    
    
    @ParameterizedTest
    @MethodSource(value = "initData")  //hàm cung cấp data, ngầm định thứ tự
    // của các phần tử mảng, map vào tham số hàm
   public void testGetFactorialGivenRightArgReturnWell(int input, long expected){
        assertEquals(expected, getFactorial(input));
   }
   
    
    
    
    
//   @Test
//   public void testGetFactorialGivenRightArgReturnWell(){
//       assertEquals(24,getFactorial(4) );
//   }
//   
   //Bắt ngoại lệ khi đưa data cà chớn
   //@Test(expected = tên ngoại lệ.class) JUnit 4, còn JUnit 5 k sử dụng v
   @Test
   public void testGetFactorialGivenWrongArgThrowException(){
       
       //sử dụng biểu thức lambda
       //hàm nhận tham số thứ 2 là 1 object/ có code implement cái
       //functional interface tên là executable - có 1 hàm duy nhất k code
       // tên là execute()
       
//       Executable exObject = new Executable() {
//           @Override
//           public void execute() throws Throwable {
//               getFactorial(-5);
//           }
//       };
               
       //assertThrows(IllegalArgumentException.class, exObject);
       
       
//       Executable exOject = () -> {getFactorial(-5);};
//       assertThrows(IllegalArgumentException.class, exOject);

        assertThrows(IllegalArgumentException.class, () -> getFactorial(-5));
        

   }
}
