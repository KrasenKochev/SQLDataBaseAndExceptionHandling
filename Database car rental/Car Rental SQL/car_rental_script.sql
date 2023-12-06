create table categories
(
    category_id   int auto_increment
        primary key,
    category_name varchar(30) not null
);

create table cars
(
    car_id          int(35) auto_increment
        primary key,
    category_id     int         not null,
    brand_name      varchar(30) not null,
    model_name      varchar(30) not null,
    production_year int         not null,
    mileage         int         not null,
    color           varchar(15) not null,
    constraint cars_categories_fk
        foreign key (category_id) references categories (category_id)
);

create table customers
(
    customer_id    int auto_increment
        primary key,
    customer_name  varchar(50)  not null,
    customer_email varchar(100) not null,
    customer_phone varchar(50)  not null
);

create table insurance
(
    insurance_id   int auto_increment
        primary key,
    insurance_type varchar(50) not null
);

create table locations
(
    location_id int auto_increment
        primary key,
    city        varchar(30) not null
);

create table options
(
    option_id   int auto_increment
        primary key,
    option_name varchar(50) not null
);

create table reservations
(
    reservation_id       int auto_increment
        primary key,
    customer_id          int  not null,
    car_id               int  not null,
    pick_up_location_id  int  null,
    drop_off_location_id int  null,
    start_date           date not null,
    end_date             date not null,
    category_id          int  not null,
    option_id            int  null,
    insurance_id         int  null,
    constraint reservations_cars_fk
        foreign key (car_id) references cars (car_id),
    constraint reservations_category_id_category
        foreign key (category_id) references categories (category_id),
    constraint reservations_customers_fk
        foreign key (customer_id) references customers (customer_id),
    constraint reservations_drop_off_locations_fk
        foreign key (drop_off_location_id) references locations (location_id),
    constraint reservations_insurance_id_insurance_fk
        foreign key (insurance_id) references insurance (insurance_id),
    constraint reservations_option_id_options_fk
        foreign key (option_id) references options (option_id),
    constraint reservations_pick_up_locations_fk
        foreign key (pick_up_location_id) references locations (location_id)
);

create table charges
(
    charges_id     int auto_increment
        primary key,
    reservation_id int null,
    insurance_id   int null,
    option_id      int null,
    charge_amount  int not null,
    constraint charges_insurance_id_insurance_fk
        foreign key (insurance_id) references insurance (insurance_id),
    constraint charges_option_id_options_fk
        foreign key (option_id) references options (option_id),
    constraint charges_reservation_id_reservation_fk
        foreign key (reservation_id) references reservations (reservation_id)
);


