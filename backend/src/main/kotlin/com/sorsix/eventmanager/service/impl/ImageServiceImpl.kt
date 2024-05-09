package com.sorsix.eventmanager.service.impl

import com.sorsix.eventmanager.domain.Event
import com.sorsix.eventmanager.domain.Image
import com.sorsix.eventmanager.domain.Thumbnail
import com.sorsix.eventmanager.repository.ImageRepository
import com.sorsix.eventmanager.service.ImageService
import org.springframework.stereotype.Service

@Service
class ImageServiceImpl (
    val imageRepository: ImageRepository
) : ImageService{
    override fun saveImage(event: Event, name: String, contentType: String, data: ByteArray): Image {
        val imageEntity = Image(event = event, name = name, contentType = contentType, data = data)
        return imageRepository.save(imageEntity)
    }

    override fun getImagesByEventId(id: Long): List<Image> {
        TODO("Not yet implemented")
    }
}