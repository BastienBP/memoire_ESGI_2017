from sklearn.datasets import load_iris
from sklearn.ensemble import RandomForestClassifier
import pandas as pd
import numpy as np

np.random.seed(0)



def initialize_model():
    print "hello"
    df = pd.read_csv("./data/creditcard.csv")
    df['is_train'] = np.random.uniform(0, 1, len(df)) <= .75
    train, test = df[df['is_train']==True], df[df['is_train']==False]
    features = df.columns[1:30]
    print features
    y = np.array(train["Class"])
    clf = RandomForestClassifier(n_jobs=2, random_state=0)
    clf.fit(train[features], y)
    
    test.to_csv("./data/df_test.csv")
    return clf, test[features]

def load_model(clf, input_row):
    return clf.predict(input_row)

