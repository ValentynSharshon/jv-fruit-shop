package core.basesyntax.strategy.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnOperationStrategy implements OperationStrategy {
    private final StorageDao storageDao;

    public ReturnOperationStrategy(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public void process(String product, int quantity) {
        int currentQuantity = storageDao.getAmountByProductName(product);
        storageDao.putProduct(product, currentQuantity + quantity);
    }
}
