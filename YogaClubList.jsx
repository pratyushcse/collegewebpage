import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css'


const YogaClubList = () => {
    const [events, setEvents] = useState([]);
    const [selectedEvent, setSelectedEvent] = useState(null);

    useEffect(() => {
        fetchEvents();
    }, []);

    const fetchEvents = async () => {
        try {
            const response = await axios.get('http://localhost:8010/api/yogaclub/events');
            setEvents(response.data);
        } catch (error) {
            console.error("There was an error fetching the events!", error);
        }
    };

    const handleEdit = (event) => {
        setSelectedEvent(event);
    };

    const handleUpdate = (updatedEvent) => {
        setSelectedEvent(updatedEvent);
    };

    return (
        <div>
            <h1>Yoga Club Events</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Topic</th>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Link</th>
                        
                    </tr>
                </thead>
                <tbody>
                    {events.map(event => (
                        <tr key={event.id}>
                            <td>{event.id}</td>
                            <td>{event.topic}</td>
                            <td>{event.date}</td>
                            <td>{event.description}</td>
                            <td>
                                <a href={event.link} target="_blank" rel="noopener noreferrer">Link</a>
                            </td>
                        
                        </tr>
                    ))}
                </tbody>
            </table>
        
        </div>
    );
};

export default YogaClubList;
