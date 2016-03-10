package com.example.evgeniy.gascount;

/**
 * Created by Evgeniy on 01.03.2016.
 */
public class Convert {

    private int id;
    private String razmer;
    private double number;
    private double itognumber;


    public double getItognumber() {

        if ( razmer.equals("Бар (bar)")&& id==2131558489 ) itognumber = number;
        else if ( razmer.equals("Бар (bar)")&& id==2131558490 ) itognumber = number*0.09999999999999;
        else if ( razmer.equals("Бар (bar)")&& id==2131558491 ) itognumber = number*0.98692326672;
        else if ( razmer.equals("Бар (bar)")&& id==2131558492 ) itognumber = number*750.0616826999999;
        else if ( razmer.equals("Бар (bar)")&& id==2131558493 ) itognumber = number*1.019716213;

        else if(razmer.equals("Мегапаскаль (МПа)")&& id==2131558489 ) itognumber = number*10.000000000000001;
        else if(razmer.equals("Мегапаскаль (МПа)")&& id==2131558490 ) itognumber = number;
        else if(razmer.equals("Мегапаскаль (МПа)")&& id==2131558491 ) itognumber = number*9.8692326672;
        else if(razmer.equals("Мегапаскаль (МПа)")&& id==2131558492 ) itognumber = number*7500.616827;
        else if(razmer.equals("Мегапаскаль (МПа)")&& id==2131558493 ) itognumber = number*10.19716213;

        else if(razmer.equals("Физическая атмосфера (атм.)")&& id==2131558489 ) itognumber = number*1.0132499999959066;
        else if(razmer.equals("Физическая атмосфера (атм.)")&& id==2131558490 ) itognumber = number*0.10132499999959064;
        else if(razmer.equals("Физическая атмосфера (атм.)")&& id==2131558491 ) itognumber = number;
        else if(razmer.equals("Физическая атмосфера (атм.)")&& id==2131558492 ) itognumber = number*759.9999999927046;
        else if(razmer.equals("Физическая атмосфера (атм.)")&& id==2131558493 ) itognumber = number*1.0332274528180758;

        else if(razmer.equals("Миллиметр ртутного столба (мм рт. ст.)")&& id==2131558489 ) itognumber = number*0.001333223684217938;
        else if(razmer.equals("Миллиметр ртутного столба (мм рт. ст.)")&& id==2131558490 ) itognumber = number*0.0001333223684217938;
        else if(razmer.equals("Миллиметр ртутного столба (мм рт. ст.)")&& id==2131558491 ) itognumber = number*0.0013157894736968412;
        else if(razmer.equals("Миллиметр ртутного столба (мм рт. ст.)")&& id==2131558492 ) itognumber = number;
        else if(razmer.equals("Миллиметр ртутного столба (мм рт. ст.)")&& id==2131558493 ) itognumber = number*0.0013595098063526236;

        else if(razmer.equals("Килограмм силы на квадратный сантиметр (кгс/см.кв)")&& id==2131558489 ) itognumber = number*0.9806649999787738;
        else if(razmer.equals("Килограмм силы на квадратный сантиметр (кгс/см.кв)")&& id==2131558490 ) itognumber = number*0.09806649999787736;
        else if(razmer.equals("Килограмм силы на квадратный сантиметр (кгс/см.кв)")&& id==2131558491 ) itognumber = number*0.9678411053370198;
        else if(razmer.equals("Килограмм силы на квадратный сантиметр (кгс/см.кв)")&& id==2131558492 ) itognumber = number*735.5592400490743;
        else if(razmer.equals("Килограмм силы на квадратный сантиметр (кгс/см.кв)")&& id==2131558493 ) itognumber = number;

        return itognumber;
    }



    public Convert(int id, String razmer, double number) {

        this.id = id;
        this.razmer = razmer;
        this.number = number;

    }



}
