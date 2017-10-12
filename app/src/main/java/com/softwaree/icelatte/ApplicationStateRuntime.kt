class ApplicationStateRuntime {
    private var instance: ApplicationStateRuntime? = null

    fun getInstance(): ApplicationStateRuntime {
        if (instance == null) {
            instance = ApplicationStateRuntime()
        }
        return instance as ApplicationStateRuntime
    }
}