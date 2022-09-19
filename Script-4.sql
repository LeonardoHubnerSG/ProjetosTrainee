create table paciente (
id serial,
nome varchar(100) not null,
cpf varchar(14),
data_nascimento varchar(10),
nome_mae varchar(100),
numero_carteirinha varchar(30),
cor_pulseira varchar(30),
primary key(id)
)

create table medico(
id serial,
nome varchar(100) not null,
cpf varchar(14),
crm varchar(50),
data_nascimento varchar(10),
primary key(id)
)

create table especialidade(
id serial,
nome varchar(100),
primary key(id)
)

create table especialidade_medico(
id serial,
medico int,
especialidade int,
primary key(id),
foreign key(medico) references medico(id),
foreign key(especialidade) references especialidade(id)
)

create table atendimento(
numero serial,
data_atendimento varchar(10),
paciente int,
medico int,
primary key(numero),
foreign key(paciente) references paciente(id),
foreign key(medico) references medico(id)
)

create table servico(
id serial,
nome varchar(100),
primary key(id)
)

create table servicos_atendimento(
id serial,
atendimento int,
servico int,
primary key(id),
foreign key(atendimento) references atendimento(numero),
foreign key(servico) references servico(id)
)

create table medicamento(
id serial,
nome varchar(100),
primary key(id)
)

create table medicamentos_atendimento(
id serial,
atendimento int,
medicamento int,
primary key(id),
foreign key(atendimento) references atendimento(numero),
foreign key(medicamento) references medicamento(id)
)

/*
delete from servicos_atendimento;
delete from servico; 
delete from medicamentos_atendimento ;
delete from medicamento ;
delete from atendimento;
delete from paciente;
delete from especialidade_medico ;
delete from especialidade; 
delete from medico ;
*/












