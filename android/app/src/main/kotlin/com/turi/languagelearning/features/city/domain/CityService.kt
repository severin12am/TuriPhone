package com.turi.languagelearning.features.city.domain

import com.turi.languagelearning.features.conversation.domain.Character

/**
 * Clean 3D city exploration service
 * Native OpenGL/Vulkan implementation
 */
interface CityService {
    
    // City Management
    suspend fun loadCity(): CityResult
    suspend fun loadCharacters(): List<Character>
    
    // Player Movement
    fun movePlayer(deltaX: Float, deltaY: Float, deltaZ: Float)
    fun rotatePlayer(yaw: Float, pitch: Float)
    fun getPlayerPosition(): Vector3
    fun getPlayerRotation(): Vector3
    
    // Character Interaction
    fun getNearbyCharacters(radius: Float = 2.0f): List<Character>
    fun getCharacterAt(position: Vector3, radius: Float = 1.0f): Character?
    fun isCharacterInRange(characterId: String, range: Float = 2.0f): Boolean
    
    // Camera Controls
    fun setCameraPosition(position: Vector3)
    fun setCameraTarget(target: Vector3)
    fun getCameraPosition(): Vector3
    fun getCameraTarget(): Vector3
    
    // Touch Input
    fun handleTouchMove(deltaX: Float, deltaY: Float)
    fun handleTouchZoom(scale: Float)
    fun handleTouchTap(screenX: Float, screenY: Float): TouchResult
    
    // Rendering
    fun render()
    fun resize(width: Int, height: Int)
    
    // Lifecycle
    fun initialize()
    fun cleanup()
}

/**
 * 3D Vector
 */
data class Vector3(
    val x: Float = 0f,
    val y: Float = 0f,
    val z: Float = 0f
) {
    operator fun plus(other: Vector3) = Vector3(x + other.x, y + other.y, z + other.z)
    operator fun minus(other: Vector3) = Vector3(x - other.x, y - other.y, z - other.z)
    operator fun times(scalar: Float) = Vector3(x * scalar, y * scalar, z * scalar)
    
    fun length(): Float = kotlin.math.sqrt(x * x + y * y + z * z)
    fun normalize(): Vector3 {
        val len = length()
        return if (len > 0) Vector3(x / len, y / len, z / len) else Vector3()
    }
    
    fun distance(other: Vector3): Float = (this - other).length()
}

/**
 * City loading result
 */
sealed class CityResult {
    object Loading : CityResult()
    data class Success(val cityModel: CityModel) : CityResult()
    data class Error(val message: String) : CityResult()
}

/**
 * City model data
 */
data class CityModel(
    val id: String,
    val name: String,
    val modelPath: String,
    val spawnPoints: List<Vector3>,
    val characterPositions: Map<String, Vector3>,
    val boundaries: CityBoundaries
)

/**
 * City boundaries for player movement
 */
data class CityBoundaries(
    val minX: Float,
    val maxX: Float,
    val minZ: Float,
    val maxZ: Float,
    val groundLevel: Float = 0f
)

/**
 * Touch interaction result
 */
sealed class TouchResult {
    object None : TouchResult()
    data class CharacterTapped(val character: Character) : TouchResult()
    data class GroundTapped(val position: Vector3) : TouchResult()
    data class ObjectTapped(val objectId: String, val position: Vector3) : TouchResult()
}

/**
 * Player state
 */
data class PlayerState(
    val position: Vector3 = Vector3(0f, 0f, 5f),
    val rotation: Vector3 = Vector3(0f, 0f, 0f),
    val movementSpeed: Float = 2.5f,
    val rotationSpeed: Float = 1.0f,
    val isMoving: Boolean = false
)

/**
 * Camera state
 */
data class CameraState(
    val position: Vector3 = Vector3(0f, 2f, 5f),
    val target: Vector3 = Vector3(0f, 0f, 0f),
    val up: Vector3 = Vector3(0f, 1f, 0f),
    val fov: Float = 45f,
    val nearPlane: Float = 0.1f,
    val farPlane: Float = 100f
)