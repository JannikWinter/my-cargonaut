package my_cargonaut.utility.data_classes.user;

public enum CarManufacturer {
    AlfaRomeo,
    AMG,
    AstonMartin,
    Audi,
    Bentley,
    Bugatti,
    BMW,
    Buick,
    Cadillac,
    Chevrolet,
    Citroen,
    Chrysler,
    Daihatsu,
    Dacia,
    Dodge,
    Ferrari,
    Fiat,
    Ford,
    GeneralMotors,
    GMC,
    Honda,
    Hummer,
    Hyundai,
    Infiniti,
    Jaguar,
    Jeep,
    Kia,
    Lada,
    Lamborghini,
    Lancia,
    LandRover,
    Lexus,
    Lincoln,
    Lotus,
    Maybach,
    Maserati,
    Mazda,
    McLaren,
    MercedesBenz,
    Mini,
    Mitsubishi,
    Nissan,
    Oldsmobile,
    OpelVauxhall,
    Peugeot,
    Plymouth,
    Porsche,
    Renault,
    RollsRoyce,
    Saab,
    Seat,
    Skoda,
    Subaru,
    Suzuki,
    Tesla,
    Toyota,
    Volkswagen,
    Volvo;

    @Override
    public String toString(){
        return switch (this) {
            case AlfaRomeo -> "Alfa-Romeo";
            case AstonMartin -> "Aston-Martin";
            case GeneralMotors -> "General Motors";
            case LandRover -> "Land Rover";
            case MercedesBenz -> "Mercedes-Benz";
            case OpelVauxhall -> "Opel/Vauxhall";
            case RollsRoyce -> "Rolls-Royce";
            default -> super.toString();
        };
    }
    //Found on https://stackoverflow.com/questions/7662424/how-do-i-reimplement-valueof-on-enumeration
    public static CarManufacturer permissiveValueOf(String carManufacturer){
        for (CarManufacturer enumValue: CarManufacturer.values()){
            return switch (carManufacturer) {
                case "Alfa-Romeo" -> AlfaRomeo;
                case "Aston-Martin" -> AstonMartin;
                case "General Motors" -> GeneralMotors;
                case "Land Rover" -> LandRover;
                case "Mercedes-Benz" -> MercedesBenz;
                case "Opel/Vauxhall" -> OpelVauxhall;
                case "Rolls-Royce" -> RollsRoyce;
                default -> CarManufacturer.valueOf(carManufacturer);
            };

        }
        return null;
    }



}

