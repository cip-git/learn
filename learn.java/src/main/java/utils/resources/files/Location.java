package utils.resources.files;

public enum Location {
    SRC_MAIN_JAVA{
        @Override
        public String asPath() {
            return Separation.FILE_SEPARATOR.separationOf(ResourcesOld.SRC_MAIN_JAVA);
        }

        @Override
        public String asPackage() {
            return Separation.DOT.separationOf(ResourcesOld.SRC_MAIN_JAVA);
        }
    };

    public  abstract String asPath();
    public abstract String asPackage();
}


