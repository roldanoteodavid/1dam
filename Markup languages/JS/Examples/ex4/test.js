var assert = require('assert');
const assignment2 = require("./assignment2.js");
var x = true;
describe('Practica1', function () {
  describe('Ejercicio1', function () {
    it('Ejercicio misterio1', function () {
        assert.equal(assignment2.misterio1(23), "Puedes conducir");
        assert.equal(assignment2.misterio1(18), "Puedes conducir");
        assert.equal(assignment2.misterio1(30), "Puedes conducir");
        assert.equal(assignment2.misterio1(120), "Puedes conducir");
        assert.equal(assignment2.misterio1(66), "Puedes conducir");
        assert.equal(assignment2.misterio1(87), "Puedes conducir");
        assert.equal(assignment2.misterio1(-15), "Introduce un numero válido");
        assert.equal(assignment2.misterio1(1000), "Introduce un numero válido");
        assert.equal(assignment2.misterio1("4"), "Introduce un numero válido");
        assert.equal(assignment2.misterio1("23"), "Introduce un numero válido");
        assert.equal(assignment2.misterio1("hola"), "Introduce un numero válido");
        assert.equal(assignment2.misterio1(["hola"]), "Introduce un numero válido");
    });
  });
  describe('Ejercicio2', function () {
    it('Ejercicio misterio2', function () {
        assert.equal(assignment2.misterio2(1),"Enero");
        assert.equal(assignment2.misterio2(2),"Febrero");
        assert.equal(assignment2.misterio2(3),"Marzo");
        assert.equal(assignment2.misterio2(4),"Abril");
        assert.equal(assignment2.misterio2(5),"Mayo");
        assert.equal(assignment2.misterio2(6),"Junio");
        assert.equal(assignment2.misterio2(7),"Julio");
        assert.equal(assignment2.misterio2(8),"Agosto");
        assert.equal(assignment2.misterio2(9),"Septiembre");
        assert.equal(assignment2.misterio2(10),"Octubre");
        assert.equal(assignment2.misterio2(11),"Noviembre");
        assert.equal(assignment2.misterio2(12),"Diciembre");
        assert.equal(assignment2.misterio2(13),"No es un mes");
        assert.equal(assignment2.misterio2(0),"No es un mes");
        assert.equal(assignment2.misterio2(-1),"No es un mes");
        assert.equal(assignment2.misterio2("5"),"Mayo");
        assert.equal(assignment2.misterio2("6"),"Junio");
        assert.equal(assignment2.misterio2("3"),"Marzo");
    });
  });
  describe('Ejercicio3', function () {
    it('Ejercicio misterio3', function () {
        assert.equal(assignment2.misterio3("suma",1,2),3);
        assert.equal(assignment2.misterio3("suma",65,2),67);
        assert.equal(assignment2.misterio3("suma",-1,-2),-3);
        assert.equal(assignment2.misterio3("suma",0,12),12);
        assert.equal(assignment2.misterio3("suma","1",2),"Los valores no son números");
        assert.equal(assignment2.misterio3("suma",1,"2"),"Los valores no son números");
        assert.equal(assignment2.misterio3("resta",1,2),-1);
        assert.equal(assignment2.misterio3("resta",65,2),63);
        assert.equal(assignment2.misterio3("resta",-1,-2),1);
        assert.equal(assignment2.misterio3("resta",0,12),-12);
        assert.equal(assignment2.misterio3("resta","1",2),"Los valores no son números");
        assert.equal(assignment2.misterio3("resta",1,"2"),"Los valores no son números");
        
        assert.equal(assignment2.misterio3("multiplicación",1,2),2);
        assert.equal(assignment2.misterio3("multiplicación",60,2),120);
        assert.equal(assignment2.misterio3("multiplicación",-1,30),-30);
        assert.equal(assignment2.misterio3("multiplicación",0,12),0);
        assert.equal(assignment2.misterio3("multiplicación","1",2),"Los valores no son números");
        assert.equal(assignment2.misterio3("multiplicación",1,"2"),"Los valores no son números");
        
        assert.equal(assignment2.misterio3("división",2,2),1);
        assert.equal(assignment2.misterio3("división",60,2),30);
        assert.equal(assignment2.misterio3("división",0,12),0);
        assert.equal(assignment2.misterio3("división",12,0),"No dividir por 0");
        assert.equal(assignment2.misterio3("división","1",2),"Los valores no son números");
        assert.equal(assignment2.misterio3("división",1,"2"),"Los valores no son números");
        
        assert.equal(assignment2.misterio3("sumar",1,2),"Introduce operación válida");
        assert.equal(assignment2.misterio3("otro",1,2),"Introduce operación válida");
        assert.equal(assignment2.misterio3(24,1,2),"Introduce operación válida");
    });
  });
  describe('Ejercicio4', function () {
    it('Ejercicio misterio4', function () {
        assert.equal(assignment2.misterio4(-1,"C"),"El número no es válido");
        assert.equal(assignment2.misterio4(999999999992,"C"),"El número no es válido");
        assert.equal(assignment2.misterio4(1223,"Ñ"),"La letra o el número proporcionados no son correctos");
        assert.equal(assignment2.misterio4(1223,"F"),"La letra o el número proporcionados no son correctos");
        assert.equal(assignment2.misterio4(122,"A"),"La letra o el número proporcionados no son correctos");
        assert.equal(assignment2.misterio4(24811101,"N"),"El DNI es correcto");
        assert.equal(assignment2.misterio4(23363998,"T"),"El DNI es correcto");
        assert.equal(assignment2.misterio4(86104969,"F"),"El DNI es correcto");
        assert.equal(assignment2.misterio4(8523648,"D"),"El DNI es correcto");
    });
  });
  describe('Ejercicio5', function () {
    it('Ejercicio misterio5', function () {
        assert.equal(assignment2.misterio5([1,3,2,4]),2);
        assert.equal(assignment2.misterio5([1,3,"hola",4]),"hola");
        assert.equal(assignment2.misterio5([1,3,25,4]),25);
        assert.equal(assignment2.misterio5([1,3]),"No es posible");
        assert.equal(assignment2.misterio5("hola"),"No es posible");
        assert.equal(assignment2.misterio5(23),"No es posible");
    });
  });
   describe('Ejercicio6', function () {
    it('Ejercicio misterio6', function () {
        assert.equal(assignment2.misterio6("A"),"Nota entre 8 y 10");
        assert.equal(assignment2.misterio6("B"),"Nota entre 6.5 y 8");
        assert.equal(assignment2.misterio6("C"),"Nota entre 5 y 6.5");
        assert.equal(assignment2.misterio6("D"),"Nota entre 4 y 5");
        assert.equal(assignment2.misterio6("E"),"Nota entre 0 y 4");
        assert.equal(assignment2.misterio6("f"),"Introduce una nota válida");
        assert.equal(assignment2.misterio6("hola"),"Introduce una nota válida");
        assert.equal(assignment2.misterio6(10),"Introduce una nota válida");
    });
  });
  describe('Ejercicio7', function () {
    it('Ejercicio misterio7', function () {
        assert.equal(assignment2.misterio7(100),1);
        assert.equal(assignment2.misterio7(99),2);
        assert.equal(assignment2.misterio7(199),1);
        assert.equal(assignment2.misterio7(20),5);
        assert.equal(assignment2.misterio7(10),10);
        assert.equal(assignment2.misterio7(-1),"Introduce un número positivo");
        assert.equal(assignment2.misterio7("hola"),"Introduce un número positivo");
    });
  });
  describe('Ejercicio8', function () {
    it('Ejercicio misterio8', function () {
        assert.equal(assignment2.misterio8(1),"1x1=1,2x1=2,3x1=3,4x1=4,5x1=5,6x1=6,7x1=7,8x1=8,9x1=9.");
        assert.equal(assignment2.misterio8(2),"1x2=2,2x2=4,3x2=6,4x2=8,5x2=10,6x2=12,7x2=14,8x2=16,9x2=18.");
        assert.equal(assignment2.misterio8(3),"1x3=3,2x3=6,3x3=9,4x3=12,5x3=15,6x3=18,7x3=21,8x3=24,9x3=27.");
        assert.equal(assignment2.misterio8(4),"1x4=4,2x4=8,3x4=12,4x4=16,5x4=20,6x4=24,7x4=28,8x4=32,9x4=36.");
        assert.equal(assignment2.misterio8(5),"1x5=5,2x5=10,3x5=15,4x5=20,5x5=25,6x5=30,7x5=35,8x5=40,9x5=45.");
        assert.equal(assignment2.misterio8(6),"1x6=6,2x6=12,3x6=18,4x6=24,5x6=30,6x6=36,7x6=42,8x6=48,9x6=54.");
        assert.equal(assignment2.misterio8(7),"1x7=7,2x7=14,3x7=21,4x7=28,5x7=35,6x7=42,7x7=49,8x7=56,9x7=63.");
        assert.equal(assignment2.misterio8(8),"1x8=8,2x8=16,3x8=24,4x8=32,5x8=40,6x8=48,7x8=56,8x8=64,9x8=72.");
        assert.equal(assignment2.misterio8("8"),"1x8=8,2x8=16,3x8=24,4x8=32,5x8=40,6x8=48,7x8=56,8x8=64,9x8=72.");
        assert.equal(assignment2.misterio8(9),"1x9=9,2x9=18,3x9=27,4x9=36,5x9=45,6x9=54,7x9=63,8x9=72,9x9=81.");
        assert.equal(assignment2.misterio8(0),"Introduce un número de 1 a 9");
        assert.equal(assignment2.misterio8(10),"Introduce un número de 1 a 9");
        assert.equal(assignment2.misterio8(-1),"Introduce un número de 1 a 9");
        assert.equal(assignment2.misterio8("hola"),"Introduce un número de 1 a 9");
    });
  });
  describe('Ejercicio9', function () {
    it('Ejercicio misterio9', function () {
        assert.equal(assignment2.misterio9(1,1),"<table><tr><td></td></tr></table>");
        assert.equal(assignment2.misterio9(2,5),"<table><tr><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td></tr></table>");
        assert.equal(assignment2.misterio9(3,8),"<table><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></table>");
        assert.equal(assignment2.misterio9(6,4),"<table><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td></tr></table>");
        assert.equal(assignment2.misterio9(2,3),"<table><tr><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td></tr></table>");
        assert.equal(assignment2.misterio9(9,9),"<table><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></table>");
        assert.equal(assignment2.misterio9(10,1),"Introduce dos números positivos menores que 10");
        assert.equal(assignment2.misterio9(1,10),"Introduce dos números positivos menores que 10");
        assert.equal(assignment2.misterio9("hola",1),"Introduce dos números positivos menores que 10");
        assert.equal(assignment2.misterio9(1,"hola"),"Introduce dos números positivos menores que 10");
    });
  });
  describe('Ejercicio10', function () {
    it('Ejercicio misterio10', function () {
      assert.equal(assignment2.misterio10(),"Hoy es el día "+new Date().getDay()+" del mes "+new Date().getMonth());
      });
  });
  describe('Ejercicio11', function () {
    it('Ejercicio misterio11', function () {
        assert.equal(assignment2.misterio11("hola"),"longitud:4");
        assert.equal(assignment2.misterio11("hola2"),"longitud:5");
        assert.equal(assignment2.misterio11("dia"),"longitud:3");
        assert.equal(assignment2.misterio11("algoritmo"),"longitud:9");
        assert.equal(assignment2.misterio11("askjldhaskjhfg"),"substring:skj");
        assert.equal(assignment2.misterio11("holaaskhgjhgd"),"substring:ola");
        assert.equal(assignment2.misterio11("holaaskhgjhgd"),"substring:ola");
        assert.equal(assignment2.misterio11("hasdhgjhgde"),"substring:asd");
        assert.equal(assignment2.misterio11("AAAASSSSSSSS"),"substring:AAA");
        assert.equal(assignment2.misterio11("pruebaotravez"),"substring:rue");
        assert.equal(assignment2.misterio11([5]),"Mete un string");
        assert.equal(assignment2.misterio11(2),"Mete un string");
    });
  });
  describe('Ejercicio12', function () {
    it('Ejercicio misterio12', function () {
      assert.equal(assignment2.misterio12("hola"),"aloh");
      assert.equal(assignment2.misterio12(2),"Mete un string");
      assert.equal(assignment2.misterio12("estoy bien"),"neib yotse");
      assert.equal(assignment2.misterio12("otto"),"otto");
      assert.equal(assignment2.misterio12("pium"),"muip");
      assert.equal(assignment2.misterio12([2]),"Mete un string");
    });
  });
  describe('Ejercicio13', function () {
    it('Ejercicio misterio13', function () {
        assert.equal(assignment2.misterio13("hola"),"HOLA");
        assert.equal(assignment2.misterio13(2),"Mete un string");
        assert.equal(assignment2.misterio13([2]),"Mete un string");
        assert.equal(assignment2.misterio13("estoy bien"),"ESTOY BIEN");
        assert.equal(assignment2.misterio13("otto"),"OTTO");
        assert.equal(assignment2.misterio13("pium"),"PIUM");

      });
  });
  describe('Ejercicio14', function () {
    it('Ejercicio misterio14', function () {
      assert.equal(assignment2.misterio14("Estoy cursando DAM"),true);
      assert.equal(assignment2.misterio14("Estoy asdasdDAMasdasd"),true);
      assert.equal(assignment2.misterio14("EstoDAM"),true);
      assert.equal(assignment2.misterio14("Estoy cursando dam"),false);
      assert.equal(assignment2.misterio14("DAM no sta mal"),true);
      assert.equal(assignment2.misterio14(["Estoy cursando DAM"]),"Mete un string");
      assert.equal(assignment2.misterio14(1),"Mete un string");
      assert.equal(assignment2.misterio14("Mete un string"),false);
    });
  });
  describe('Ejercicio15', function () {
    it('Ejercicio misterio15', function () {
      assert.equal(assignment2.misterio15("pablo","perez","martinez"),"{\"nombre\":\"pablo\",\"apellido1\":\"perez\",\"apellido2\":\"martinez\"}");
      assert.equal(assignment2.misterio15("test","perez","test"),"{\"nombre\":\"test\",\"apellido1\":\"perez\",\"apellido2\":\"test\"}");
      assert.equal(assignment2.misterio15("hola","s","e"),"{\"nombre\":\"hola\",\"apellido1\":\"s\",\"apellido2\":\"e\"}");
      assert.equal(assignment2.misterio15("pablo",2,"martinez"),"Alguno no es string");
    });
  });
   describe('Ejercicio16', function () {
    it('Ejercicio misterio16', function () {
        assert.equal(assignment2.misterio16("voy a suspender"),"voy a aprobar");
    });
  });
  describe('Ejercicio17', function () {
    it('Ejercicio misterio17', function () {
      assert.equal(assignment2.misterio17([1,2]),"<ul><li>1</li><li>2</li></ul>");
      assert.equal(assignment2.misterio17([1,2,3]),"<ul><li>1</li><li>2</li><li>3</li></ul>");
      assert.equal(assignment2.misterio17([25]),"<ul><li>25</li></ul>");
    });
  });
  describe('Ejercicio18', function () {
    it('Ejercicio misterio18', function () {
      assert.equal(assignment2.misterio18([1,2]),"<ol><li>2</li><li>1</li></ol>");
      assert.equal(assignment2.misterio18([1,3,2]),"<ol><li>2</li><li>3</li><li>1</li></ol>");
      assert.equal(assignment2.misterio18([25]),"<ol><li>25</li></ol>");
      assert.equal(assignment2.misterio18([11,2,3,56,4]),"<ol><li>4</li><li>56</li><li>3</li><li>2</li><li>11</li></ol>");
      assert.equal(assignment2.misterio18([7,6,5]),"<ol><li>5</li><li>6</li><li>7</li></ol>");
    });
  });
  describe('Ejercicio19', function () {
    it('Ejercicio misterio19', function () {
      assert.equal(assignment2.misterio19({"nombre":"pablo","apellido1":"perez","apellido2":"martinez"}),"pablo perez martinez.");
      assert.equal(assignment2.misterio19({"nombre":"pablo","apellido2":"perez","apellido1":"martinez"}),"pablo martinez perez.");
      assert.equal(assignment2.misterio19({"nombre":"javier","apellido1":"perez","apellido2":"martinez"}),"javier perez martinez.");
      assert.equal(assignment2.misterio19({"nombre":"ejemplo","apellido1":"ejemplo2","apellido2":"martinez"}),"ejemplo ejemplo2 martinez.");
    });
  });
  describe('Ejercicio20', function () {
    it('Ejercicio misterio20', function () {
      assert.equal(assignment2.misterio20([23],0),"{\"resultado\":23}");
      assert.equal(assignment2.misterio20(["hola"],0),"{\"resultado\":\"hola\"}");
      assert.equal(assignment2.misterio20([23,32],0),"{\"resultado\":23}");
      assert.equal(assignment2.misterio20([23,54,3],2),"{\"resultado\":3}");
      assert.equal(assignment2.misterio20(["hola",1,2,3],1),"{\"resultado\":1}");
      assert.equal(assignment2.misterio20(["hola","hola"],0),"{\"resultado\":\"hola\"}");
      assert.equal(assignment2.misterio20([23],-1),"No es posible");
      assert.equal(assignment2.misterio20([23],1),"No es posible");
    });
  });
});