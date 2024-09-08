package com.lld.splitwise.services;


import com.lld.splitwise.exceptions.UserNotFoundException;
import com.lld.splitwise.factories.SettleUpFactory;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.ExpenseUser;
import com.lld.splitwise.models.SettleUpAlgorithm;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.ExpenseUserRepository;
import com.lld.splitwise.repositories.UserRepository;
import com.lld.splitwise.strategies.HeapSettleUpStrategy;
import com.lld.splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    ExpenseUserRepository expenseUserRepository;

    SettleUpStrategy settleUpStrategy;

    /*
        1. get the user and validate the user
        2. get the all the expenses int which this user is involved
        3. Iterate through all the expenses and find out who has paid extra or lesser for every user involved in the above ist of expenses
        4. use Min heap and Max heap to find out the list of transactions required to settle up the user

     */

    public List<Expense> settleUpUser(Long userID)throws UserNotFoundException{

        Optional<User> optionalUser = userRepository.findById(userID);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User Not Found : userId : "+userID);
        }
        User user = optionalUser.get();
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);
        Set<Expense> expenses = new HashSet<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }
        //convert a set in to list
        List<Expense> expensesTOSettleUp = expenses.stream().toList();
        settleUpStrategy = SettleUpFactory.getSrategy(SettleUpAlgorithm.HEAP_ALGORITHM);
        return settleUpStrategy.settleUp(expensesTOSettleUp);
    }

    public List<Expense> settleUpGroup(Long groupId){

        return null;
    }
}
