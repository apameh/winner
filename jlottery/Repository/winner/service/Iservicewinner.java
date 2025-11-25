package ir.mapsa.jlottery.Repository.winner.service;

public interface Iservicewinner {
    package ir.mapsa.jlottery.jlottery.service;

import ir.mapsa.jlottery.jlottery.model.winner;
import ir.mapsa.jlottery.jlottery.model.winner;

import java.util.List;

    public interface IService winner {
       // لیست برندگان را برگردونه

       winner add( Winner winner);

        //لیستی از مشتریان را از دیتا بیس میخواند و برمیگرداند
        List<winner> getAll();
      winner update(winner winner);

        void delete(winner winner);
    }
}
