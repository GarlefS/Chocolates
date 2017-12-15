create table
tbl_marca (codigomarca number(3),marca varchar2(80),
    PRIMARY KEY (codigomarca));
    
create table
tbl_chocolate (codigo number(3), nombre varchar2(60),descripcion varchar2(255), precio integer, cantidad integer,
    tipochocolate varchar2(100), tiposabor varchar2(95), codigomarca number(3), azucar varchar2(40),
    PRIMARY KEY (codigo),
    FOREIGN KEY (codigomarca) REFERENCES tbl_marca (codigomarca));


    



CREATE SEQUENCE seq_codigo_choc
MINVALUE 1
START WITH 1
INCREMENT BY 1
NOCACHE;

create table
tb_sabor (tiposabor varchar2(95),
    PRIMARY KEY (tiposabor),
    FOREIGN KEY (tiposabor) REFERENCES tb_chocolate (tiposabor));

    
 