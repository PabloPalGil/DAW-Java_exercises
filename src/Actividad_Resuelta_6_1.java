public class Actividad_Resuelta_6_1 {
/*Escribir un programa que muestre todos los caracteres Unicode junto a su code point, cuyo valor
esté comprendido entre \u0000 y \uFFFF */
    public static void main(String[] args){
        //Indicamos números en base hexadecimal con el prefijo 0x
        for(int codePoint = 0x0000; codePoint <= 0xFFFF; codePoint++){
            String xxxx = Integer.toHexString(codePoint);
            String yyyy = String.valueOf(codePoint);
            System.out.println("\\u" + xxxx + " / " + yyyy + ": " + (char)codePoint);
        }
    }
}
