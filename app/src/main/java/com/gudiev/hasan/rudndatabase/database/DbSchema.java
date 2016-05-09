package com.gudiev.hasan.rudndatabase.database;

public class DbSchema {

    public static final class GroupTable {
        public static final String NAME = "gp";

        public static final class Cols {
            public static final String ID ="_id";
            public static final String NAME = "name";
        }
    }

    public static final class StudentTable {
        public static final String NAME = "student";

        public static final class Cols {
            public static final String ID = "_id";
            public static final String NAME = "name";
            public static final String GROUP_ID = "gp_id";
        }
    }
}
