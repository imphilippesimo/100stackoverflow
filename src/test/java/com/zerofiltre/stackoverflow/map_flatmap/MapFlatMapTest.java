package com.zerofiltre.stackoverflow.map_flatmap;


import java.util.Optional;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;


public class MapFlatMapTest {


  void onFunctionalProgramming() {

    Optional<Integer> integerOptional = Optional.of(20);
    Optional<Optional<Integer>> integerOptionalOptional = Optional.of(Optional.of(20));

    integerOptional = integerOptional.map(

        //Function<Integer,Integer> une fonction qui prend un integer et retourne un integer
        integer -> {
          System.out.println(integer);
          return integer;
        }

    ); //<--  map retourne bel et bien un Optional<Integer>


    integerOptionalOptional = integerOptional.map(

        //Function<Integer,Optional<Integer>> une fonction qui prend un integer et retourne un Optional<integer>
        integer -> {
          System.out.println(integer);
          return Optional.of(integer);
        }

    ); //<--  map retourne un Optional<Optional<Integer>>

    integerOptional = integerOptional.flatMap(

        //Function<Integer,Optional<Integer>> une fonction qui prend un integer et retourne un Optional<integer>
        integer -> {
          System.out.println(integer);
          return Optional.of(integer);
        }

    ); //<--  flatmap applatit et retourne un Optional<Integer>

  }

}
