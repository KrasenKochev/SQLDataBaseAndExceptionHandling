package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.exeptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.EnumSet;

public class CommandFactoryImpl implements CommandFactory {

    private static final String COMMAND_S_IS_NOT_SUPPORTED = "Command %s is not supported.";

    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {

//        //TODO Validate command format
        try {
            ValidationHelper.validateCommandType(commandTypeValue);
        } catch (InvalidCommandException e) {
            throw new InvalidCommandException(String.format(COMMAND_S_IS_NOT_SUPPORTED, commandTypeValue));
        }
        CommandType commandType = CommandType.valueOf(commandTypeValue.toUpperCase());
        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategoryCommand(productRepository);
            case CREATEPRODUCT:
                return new CreateProductCommand(productRepository);
            case ADDPRODUCTTOCATEGORY:
                return new AddProductToCategoryCommand(productRepository);
            case SHOWCATEGORY:
                return new ShowCategoryCommand(productRepository);
            default:
                //TODO Can we improve this code?
                throw new InvalidCommandException(String.format("Command %s is not supported.", commandTypeValue));
        }
//        try {
//           ValidationHelper.validateCommandType(commandTypeValue);
//            ArrayList<String> listOfEnumsCommands = new ArrayList<>();
//
//            EnumSet.allOf(CommandType.class)
//                .forEach(commandType -> listOfEnumsCommands.add(commandType.toString().toUpperCase()));
//
//
//            if (commandTypeValue.equalsIgnoreCase("CREATECATEGORY")){
//                return new CreateCategoryCommand(productRepository);
//            }
//            if (commandTypeValue.equalsIgnoreCase("CREATEPRODUCT")){
//                return new CreateCategoryCommand(productRepository);
//            }if (commandTypeValue.equalsIgnoreCase("ADDPRODUCTTOCATEGORY")){
//                return new CreateCategoryCommand(productRepository);
//            }if (commandTypeValue.equalsIgnoreCase("SHOWCATEGORY")){
//                return new CreateCategoryCommand(productRepository);
//            }else {
//                throw new InvalidCommandException(String.format(COMMAND_S_IS_NOT_SUPPORTED,commandTypeValue));
//            }
//        }catch (InvalidCommandException e){
//           throw new InvalidCommandException(String.format(COMMAND_S_IS_NOT_SUPPORTED,commandTypeValue));
//        }

    }

}
