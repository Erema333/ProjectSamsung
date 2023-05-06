package com.example.projectsamsung;

public class SpriteLogic {
    public static float x;
    public static float y;
    public static int score = 0;
    public enum Shape { // список всех картинок
        Yna, Heh, Masha
    }

public static void getDeleteSprite(){
//stations.remove(0);
//updateGame();
}

    /*public SpriteLogic(Context context){
       sprites.add(new BitmapSprite(context,getRandomShape()));
}*/

    public SpriteDraw onTouchSprite(){ // DO: массив удаляющий спрайт если на него нажали

        return null;
    }



       /* for (int i = 0; i < stations.size(); i++) {
            System.out.println("x:" + x+"spX:"+ getCordX());
            System.out.println("y:" + y+"spY:"+ getCordY());
            System.out.println(stations.size());
            if (stations.get(i) != null){
            if(((x < getCordX()&&x > getCordX()-30)||x > getCordX()&&x < getCordX()+30)
             &&((y < getCordY()&&y > getCordY()-30)||y > getCordY()&&y < getCordY()+30) ){
                System.out.println("попал!");
                stations.remove(i);

                updateGame();
                return true;
            }}
        }

        return false;
*/

/*
   public static void CordTest(){
        int g = 0;
        while (g != -5) {
            g = 0;
            y = (float) (Math.random() * (2000 - 30) + 30);

            x = (float) (Math.random() * (1000 - 30) + 30);
            Collections.sort(CordY);
            Collections.sort(CordX);

            //==========================================
            for (int i = 0; i < CordY.size(); i++) {
                if (CordY.get(i) != null) {
                    if ((((float) CordY.get(i)+ 40 > y ) || ((float) CordY.get(i)- 40 < y ))||
                            (((float) CordX.get(i)+ 40 > x ) || ((float) CordX.get(i)- 40 < x ))) {
                        g++;h
                        System.out.println(x + " "+ y);

                    } else break;
                }
            }
            //===========================================
            if (g == CordY.size()) {
                g = -5;

                CordY.add(y);
                CordX.add(x);
            }
        }



    }*/


}
