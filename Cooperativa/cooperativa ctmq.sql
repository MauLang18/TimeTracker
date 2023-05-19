create database db_cooperativa character set utf8 collate utf8_spanish_ci;

use db_cooperativa;

create table tb_afiliacion(
cedula int not null,
nombre varchar(20) not null,
apellido1 varchar(20) not null,
apellido2 varchar(20) not null,
correo varchar(60) not null,
fechaNaci date not null,
telefono int not null,
direccion varchar(100) not null,
seccion varchar(6),
especialidad varchar(60) not null,
enfermedad varchar(70),
beneficiario varchar(20) not null,
apellido1b varchar(20) not null,
apellido2b varchar(20) not null,
cedulab int not null,
funcionari varchar(70) not null,
funcion varchar(30) default 'Docente con Recargo',
fechaIngreso date, 
nacionalidad varchar(45),
primary key(cedula));

create table tb_asociados(
numero varchar(20) not null,
nom varchar(20) not null,
ap1 varchar(20) not null,
ap2 varchar(20) not null,
ced int not null,
fecha date not null,
calidad varchar(1) not null,
nivel varchar(6),
cuota int not null default '500',
estado varchar(1) not null,
retiro date,
constraint fk_cedu foreign key (ced) references tb_afiliacion(cedula),
primary key(numero));

create table tb_aportacion(
id int auto_increment not null,
num varchar(20) not null,
nomb varchar(20) not null,
ape1 varchar(20) not null,
ape2 varchar(20) not null,
acumulada int not null,
mes varchar(15) not null,
recibo varchar(30) not null,
fec date not null,
certificados varchar(60) not null,
tot int,
año varchar(5) not null,
monto1 int,
constraint fk_num foreign key (num) references tb_asociados(numero),
primary key(id));

create table tb_ahorro(
id int auto_increment not null,
asociado varchar(20) not null,
nombr varchar(20) not null,
apel1 varchar(20) not null,
apel2 varchar(20) not null,
cedula int not null,
mon int not null,
fech date not null,
total decimal(10,2) not null,
corte date not null,
final decimal(10,2),
constraint fk_aso foreign key (asociado) references tb_asociados(numero),
primary key(id));

create table tb_bazar(
cod int not null auto_increment,
articulo varchar(30) not null,
modelo varchar(30),
precio int not null,
existencias int not null,
cantidad int default '0',
primary key(cod));

create table tb_libros(
codi int not null auto_increment,
libro varchar(30) not null,
grado varchar(10) not null,
pre int not null,
exis int not null,
cantidad int default '0',
primary key(codi));

create table tb_ocasional(
codig int not null auto_increment,
actividad varchar(50) not null,
dia date not null,
recuadacion int not null,
primary key(codig));

create table tb_ventas(
id int auto_increment,
id_ba int,
id_li int,
producto varchar(30) not null,
grado varchar(10),
cantidad int,
precio int,
fecha date not null,
constraint fk_ba foreign key (id_ba) references tb_bazar(cod),
constraint fk_li foreign key (id_li) references tb_libros(codi),
primary key(id));

create table tb_tipo(
id int not null auto_increment,
tipo varchar(45) not null,
primary key(id));

create table tb_usuario(
ide int not null auto_increment,
usuario varchar(45) not null,
pass varchar(45) not null,
afiliacion int not null,
admision int not null,
aportacion int not null,
ahorro int not null,
bazar int not null,
libros int not null,
ocasional int not null,
ventas int not null,
registro int not null,
id_tipo int,
constraint fk_tipo foreign key (id_tipo) references tb_tipo(id),
primary key(ide));

insert into tb_tipo values (1,'admin'),(2,'comunal');

insert into tb_usuario values(1,'ADMIN','Maxicoop2021','2','2','2','2','2','2','2','2','2',1),(2,'Comunal','Estudiantes','2','2','2','2','2','2','2','2','2',2);

DELIMITER // 

CREATE PROCEDURE resta 
(In mon int,
in i int) 
begin
update tb_aportacion set tot=tot+mon where id=i;
END//

DELIMITER ;

DELIMITER // 

CREATE PROCEDURE suma
(In mon int,
in i int,
in apo int) 
begin
update tb_aportacion set tot=apo+mon where id=i;
END//

DELIMITER ;

insert into tb_afiliacion values (119087809,'Jesus','Madrigal','Castillo','yisusmaca@gmail.com','2004-07-17',89064587,'Patarra','11-1','Electronica Industrial','Ninguna','Ana','Madrigal','Castillo',118092387,'Wendy Araya','Docente con Recargo','2021-09-11','Costarricense');

insert into tb_asociados values ('621-2021','Jesus','Madrigal','Castillo',119087809,'2021-09-11','E','11-1',500,'A','2022-11-30');

insert into tb_aportacion values (null,'621-2021','Jesus','Madrigal','Castillo',1200,'Septiembre','c34','2021-09-11','4',1200,'2021',600);

insert into tb_ahorro values (null,'621-2021','Jesus','Madrigal','Castillo',119087809,100000,'2021-04-01',0,'2021-10-30',104876.0);

insert into tb_bazar values (null,'Lapiz','N/A',500,10,0);

insert into tb_libros values (null,'Español','Septimo',10000,10,0);

insert into tb_ocasional values (null,'Dia del libro','2021-04-23',150000);

delimiter //

create procedure total
(in mont int,
in inter decimal(10,2),
in i int)
begin
update tb_ahorro set total=mont+inter where id=i;
end//

delimiter ;

delimiter //

create procedure ingresarAF
(in _cedula int,
in _nombre varchar(20),
in _apellido1 varchar(20),
in _apellido2 varchar(20),
in _correo varchar(60),
in _fecha date,
in _telefono int,
in _direccion varchar(100),
in _seccion varchar(6),
in _especialidad varchar(60),
in _enfermedad varchar(70),
in _beneficiario varchar(20),
in _apellido1b varchar(20),
in _apellido2b varchar(20),
in _cedulab int,
in _funcionario varchar(70),
in _funcion varchar(30),
in _fechaI date,
in _nacionalidad varchar(45))
begin
insert into tb_afiliacion (cedula,nombre,apellido1,apellido2,correo,fechaNaci,telefono,direccion,seccion,especialidad,enfermedad,beneficiario,apellido1b,apellido2b,cedulab,funcionari,funcion,fechaIngreso,nacionalidad) values (_cedula,_nombre,_apellido1,_apellido2,_correo,_fecha,_telefono,_direccion,_seccion,_especialidad,_enfermedad,_beneficiario,_apellido1b,_apellido2b,_cedulab,_funcionario,_funcion,_fechaI,_nacionalidad);
end//

delimiter ;

delimiter //

create procedure modificarAF
(in _cedula int,
in _nombre varchar(20),
in _apellido1 varchar(20),
in _apellido2 varchar(20),
in _correo varchar(60),
in _fecha date,
in _telefono int,
in _direccion varchar(100),
in _seccion varchar(6),
in _especialidad varchar(60),
in _enfermedad varchar(70),
in _beneficiario varchar(20),
in _apellido1b varchar(20),
in _apellido2b varchar(20),
in _cedulab int,
in _funcionario varchar(70),
in _funcion varchar(30),
in _nacionalidad varchar(45))
begin
update tb_afiliacion set nombre=_nombre,apellido1=_apellido1,apellido2=_apellido2,correo=_correo,fechaNaci=_fecha,telefono=_telefono,direccion=_direccion,seccion=_seccion,especialidad=_especialidad,enfermedad=_enfermedad,beneficiario=_beneficiario,apellido1b=_apellido1b,apellido2b=_apellido2b,cedulab=_cedulab,funcionari=_funcionario,funcion=_funcion,nacionalidad=_nacionalidad where cedula=_cedula;
end//

delimiter ;

delimiter //

create procedure eliminarAF
(in _cedula int)
begin
delete from tb_afiliacion where cedula=_cedula;
end//

delimiter ;

delimiter //

create procedure limpiarAF
()
begin
delete from tb_afiliacion; 
end//

delimiter ;

delimiter //

create procedure ingresarAD
(in _numero varchar(20),
in _nombre varchar(20),
in _apellido1 varchar(20),
in _apellido2 varchar(20),
in _cedula int,
in _fecha date,
in _calidad varchar(1),
in _nivel varchar(6),
in _cuota int,
in _estado varchar(1),
in _retiro date)
begin
insert into tb_asociados (numero,nom,ap1,ap2,ced,fecha,calidad,nivel,cuota,estado,retiro) values (_numero,_nombre,_apellido1,_apellido2,_cedula,_fecha,_calidad,_nivel,_cuota,_estado,_retiro);
end//

delimiter ;

delimiter //

create procedure modificarAD
(in _numero varchar(20),
in _nombre varchar(20),
in _apellido1 varchar(20),
in _apellido2 varchar(20),
in _cedula int,
in _fecha date,
in _calidad varchar(1),
in _nivel varchar(6),
in _cuota int,
in _estado varchar(1),
in _retiro date)
begin
update tb_asociados set nom=_nombre,ap1=_apellido1,ap2=_apellido2,ced=_cedula,fecha=_fecha,calidad=_calidad,nivel=_nivel,cuota=_cuota,estado=_estado,retiro=_retiro where numero=_numero;
end//

delimiter ;

delimiter //

create procedure eliminarAD
(in _numero varchar(20))
begin
delete from tb_asociados where numero=_numero;
end//

delimiter ;

delimiter //

create procedure limpiarAD
()
begin
delete from tb_asociados;
end//

delimiter ;

delimiter //

create procedure ingresarAP
(in _num varchar(20),
in _nomb varchar(20),
in _ape1 varchar(20),
in _ape2 varchar(20),
in _acumulada int,
in _mes varchar(15),
in _recibo varchar(30),
in _fec date,
in _certificados varchar(60),
in _tot int,
in _año int,
in _monto1 int)
begin
insert into tb_aportacion (num,nomb,ape1,ape2,acumulada,mes,recibo,fec,certificados,tot,año,monto1) values (_num,_nomb,_ape1,_ape2,_acumulada,_mes,_recibo,_fec,_certificados,_tot,_año,_monto1);
end//

delimiter ;

delimiter //

create procedure modificarAP
(in _id int,
in _num varchar(20),
in _nomb varchar(20),
in _ape1 varchar(20),
in _ape2 varchar(20),
in _acumulada int,
in _mes varchar(15),
in _recibo varchar(30),
in _fec date,
in _certificados varchar(60),
in _año int)
begin
update tb_aportacion set num=_num,nomb=_nomb,ape1=_ape1,ape2=_ape2,acumulada=_acumulada,mes=_mes,recibo=_recibo,fec=_fec,certificados=_certificados,año=_año where id=_id;
end//

delimiter ;

delimiter //

create procedure eliminarAP
(in _id int)
begin
delete from tb_aportacion where id=_id;
end//

delimiter ;

delimiter //

create procedure limpiarAP
()
begin
delete from tb_aportacion;
end//

delimiter ;

delimiter //

create procedure ingresarAH
(in _asociado varchar(20),
in _nombr varchar(20),
in _apel1 varchar(20),
in _apel2 varchar(20),
in _cedula int,
in _mon int,
in _fech date,
in _total decimal(10,2),
in _corte date,
in _final decimal(10,2))
begin
insert into tb_ahorro (asociado,nombr,apel1,apel2,cedula,mon,fech,total,corte,final) values (_asociado,_nombr,_apel1,_apel2,_cedula,_mon,_fech,_total,_corte,_final);
end//

delimiter ;

delimiter //

create procedure modificarAH
(in _id int,
in _asociado varchar(20),
in _nombr varchar(20),
in _apel1 varchar(20),
in _apel2 varchar(20),
in _cedula int,
in _mon int,
in _fech date)
begin
update tb_ahorro set asociado=_asociado,nombr=_nombr,apel1=_apel1,apel2=_apel2,cedula=_cedula,mon=_mon,fech=_fech where id=_id;
end//

delimiter ;

delimiter //

create procedure eliminarAH
(in _id int)
begin
delete from tb_ahorro where id=_id;
end//

delimiter ;

delimiter //

create procedure limpiarAH
()
begin
delete from tb_ahorro;
end//

delimiter ;

delimiter //

create procedure ingresarBA
(in _articulo varchar(30),
in _modelo varchar(30),
in _precio int,
in _existencias int)
begin
insert into tb_bazar (articulo,modelo,precio,existencias) values (_articulo,_modelo,_precio,_existencias);
end//

delimiter ;

delimiter //

create procedure modificarBA
(in _cod int,
in _articulo varchar(30),
in _modelo varchar(30),
in _precio int,
in _existencias int)
begin
update tb_bazar set articulo=_articulo,modelo=_modelo,precio=_precio,existencias=_existencias, cantidad=0 where cod=_cod;
end//

delimiter ;

delimiter //

create procedure eliminarBA
(in _cod int)
begin
delete from tb_bazar where cod=_cod;
end//

delimiter ;

delimiter //

create procedure limpiarBA
()
begin
delete from tb_bazar;
end//

delimiter ;

delimiter //

create procedure ingresarLI
(in _libro varchar(30),
in _grado varchar(10),
in _pre int,
in _exis int)
begin
insert into tb_libros (libro,grado,pre,exis) values (_libro,_grado,_pre,_exis);
end//

delimiter ;

delimiter //

create procedure modificarLI
(in _codi int,
in _libro varchar(30),
in _grado varchar(10),
in _pre int,
in _exis int)
begin
update tb_libros set libro=_libro,grado=_grado,pre=_pre,exis=_exis,cantidad=0 where codi=_codi;
end//

delimiter ;

delimiter //

create procedure eliminarLI
(in _codi int)
begin
delete from tb_libros where codi=_codi;
end//

delimiter ;

delimiter //

create procedure limpiarLI
()
begin
delete from tb_libros;
end//

delimiter ;

delimiter //

create procedure ingresarOC
(in _actividad varchar(50),
in _dia date,
in _recuadacion int)
begin
insert into tb_ocasional (actividad,dia,recuadacion) values (_actividad,_dia,_recuadacion);
end//

delimiter ;

delimiter //

create procedure modificarOC
(in _codig int,
in _actividad varchar(50),
in _dia date,
in _recuadacion int)
begin
update tb_ocasional set actividad=_actividad,dia=_dia,recuadacion=_recuadacion where codig=_codig;
end//

delimiter ;

delimiter //

create procedure eliminarOC
(in _codig int)
begin
delete from tb_ocasional where codig=_codig;
end//

delimiter ;

delimiter //

create procedure limpiarOC
()
begin
delete from tb_ocasional;
end//

delimiter ;

delimiter //

create procedure modificarLIVE
(in _id int,
in _producto varchar(30),
in _grado varchar(30),
in _precio int,
in _cantidad int)
begin
update tb_ventas set producto=_producto,grado=_grado,precio=_precio,cantidad=_cantidad where id=_id;
end//

delimiter ;

delimiter //

create procedure modificarBAVE
(in _id int,
in _producto varchar(30),
in _precio int,
in _cantidad int)
begin
update tb_ventas set producto=_producto,precio=_precio,cantidad=_cantidad where id=_id;
end//

delimiter ;

delimiter //

create procedure eliminarVE
(in _id int)
begin
delete from tb_ventas where id=_id;
end//

delimiter ;

delimiter //

create procedure limpiarVE
()
begin
delete from tb_ventas;
end//

delimiter ;

delimiter //

create procedure totalfinal
(in _cedula int,
in _total decimal(10,2))
begin
update tb_ahorro set final=final+_total where cedula=_cedula;
end//

delimiter ;

insert into tb_afiliacion values (119087810,'Fred','Gonzales','Castillo','frederygoca@gmail.com','2004-09-17',89064897,'Patarra','11-1','Electronica Industrial','Ninguna','Flor','Gonzales','Castillo',118092388,'Wendy Araya','Docente con Recargo','2021-09-11','Costarricense');

insert into tb_asociados values ('622-2021','Fred','Gonzales','Castillo',119087810,'2021-09-11','E','11-1',500,'A','2022-11-30');

insert into tb_aportacion values (null,'622-2021','Fred','Gonzales','Castillo',1200,'Septiembre','c80','2021-09-11','4',1200,'2021',600);

insert into tb_ahorro values (null,'622-2021','Fred','Gonzales','Castillo',119087810,100000,'2021-04-01',0,'2021-10-30',104876.0);

insert into tb_bazar values (null,'Calculadora','Meh',15000,10,0);

insert into tb_libros values (null,'Fisica','Decimo',10000,50,0);

insert into tb_ocasional values (null,'15 de septiembre','2021-09-14',150000);

delimiter //

create procedure retiro
(in _numero int,
in _monto int)
begin
update tb_ahorro set final=final-_monto where cedula=_numero;
end//

delimiter ;

insert into tb_afiliacion values (119087811,'Carlos','Perez','Castillo','charliepca@gmail.com','2004-11-17',89064897,'Patarra','11-1','Electronica Industrial','Ninguna','Florencia','Perez','Castillo',118092370,'Wendy Araya','Docente con Recargo','2021-09-11','Costarricense');

insert into tb_asociados values ('623-2021','Carlos','Perez','Castillo',119087811,'2021-09-11','E','11-1',500,'A','2022-11-30');

insert into tb_aportacion values (null,'623-2021','Carlos','Perez','Castillo',1200,'Septiembre','c80','2021-09-11','4',1200,'2021',600);

insert into tb_ahorro values (null,'623-2021','Carlos','Perez','Castillo',119087811,100000,'2021-04-01',0,'2021-10-30',104876.0);

insert into tb_bazar values (null,'Fichas','N/A',750,3,0);

insert into tb_libros values (null,'Quimica','Undecimo',10000,100,0);

insert into tb_ocasional values (null,'San Valentin','2021-02-14',250000);

delimiter //

create procedure exis
(in _cod int,
in _cantidad int)
begin
update tb_bazar set existencias=existencias-_cantidad, cantidad=_cantidad where cod=_cod;
end//

delimiter ;

delimiter |

create trigger bazar before update on tb_bazar
for each row begin
insert into tb_ventas (id_ba,producto,cantidad,precio,fecha) values (new.cod,new.articulo,new.cantidad,new.precio,curdate());
end |

delimiter ;

delimiter |

create trigger libros before update on tb_libros
for each row begin
insert into tb_ventas (id_li,producto,grado,cantidad,precio,fecha) values (new.codi,new.libro,new.grado,new.cantidad,new.pre,curdate());
end |

delimiter ;

delimiter //

create procedure exis1
(in _cod int,
in _cantidad int)
begin
update tb_libros set exis=exis-_cantidad, cantidad=_cantidad where codi=_cod;
end//

delimiter ;

update tb_bazar set precio=500, existencias=15 where cod=1;

update tb_libros set pre=15000, cantidad=5 where codi=1;

drop database db_cooperativa;

select * from tb_afiliacion;

select * from tb_asociados;

select * from tb_aportacion;

select * from tb_ahorro;

select * from tb_bazar;

select * from tb_libros;

select * from tb_ocasional;	

select * from tb_ventas;

insert into tb_libros values(null,'Español','Noveno',12000,10,0);

select * from tb_libros where libro='Español' and grado='Septimo';

call ingresarLI('Matematicas','Octavo',11000,30);

select * from tb_usuario;