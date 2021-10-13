package com.masdiq.simplecrudapp.Presenter

import com.masdiq.simplecrudapp.View.*

class CrudPresenter(
    private val mainActivity: MainActivity,
    private val splashActivity: SplashActivity,
    private val deleteActivity: DeleteActivity,
    private val updateActivity: UpdateActivity,
    private val createActivity: CreateActivity
) {

    // Splash Activity
    fun color() {
        splashActivity.recolorTopBar()
    }

    fun delay() {
        splashActivity.delay()
    }

    // Main Activity
    fun recolor() {
        mainActivity.recolorTopBar()
    }

    fun toCreate() {
        mainActivity.moveToCreate()
    }

    fun toUpdate() {
        mainActivity.moveToUpdate()
    }

    fun toDelete() {
        mainActivity.moveToDelete()
    }

    fun getRV() {
        mainActivity.getRecyclerView()
    }

    fun getData() {
        mainActivity.readData()
    }

    // Create Activity
    fun createPost() {
        createActivity.create()
    }

    // Delete Activity
    fun deletePost() {
        deleteActivity.delete()
    }

    // Update Activity
    fun updatePost() {
        updateActivity.update()
    }
}