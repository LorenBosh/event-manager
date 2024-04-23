package com.sorsix.eventmanager.api

import com.sorsix.eventmanager.domain.Event
import com.sorsix.eventmanager.domain.request.EventRequest
import com.sorsix.eventmanager.domain.request.PublishTicketsRequest
import com.sorsix.eventmanager.service.EventService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
class EventController(
    val eventService: EventService
) {

    @GetMapping("")
    fun getAllEvents(): List<Event>{
        return eventService.getEvents()
    }

    @GetMapping("/{id}")
    fun getEventById(@PathVariable id: Long): Event?{
        return eventService.getEventById(id)
    }

    @PostMapping("/create")
    fun createEvent(@RequestBody eventRequest: EventRequest) : ResponseEntity<Event>{
        return ResponseEntity.ok(eventService.createEvent(eventRequest))
    }

    @DeleteMapping("/{id}/delete")
    fun deleteEventById(@PathVariable id: Long) : ResponseEntity<Any>{
        return ResponseEntity.ok(eventService.deleteEvent(id))
    }

    @PutMapping("/publish")
    fun publishTicketsForEventId(@RequestBody publishTicketsRequest: PublishTicketsRequest): ResponseEntity<Any>{
        return ResponseEntity.ok(eventService.publishTicketsForEventId(publishTicketsRequest))
    }

    @PostMapping("/{id}/buy") // ?num=2
    fun buyTicketsForEventId(@PathVariable id: Long, @RequestParam num: Int = 1) : ResponseEntity<Any>{
        return ResponseEntity.ok(eventService.buyTicket(id, num))
    }
}