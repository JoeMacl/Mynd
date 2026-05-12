# Mynd - Dementia Support App

## Overview
Mynd is an Android application designed to support individuals with early-stage dementia through personalised memory reinforcement and cognitive assistance. The application allows caregivers to input meaningful personal information, which is then used to generate tailored memory prompts.

The system integrates on-device AI using Llama 3.2 to produce adaptive, user-specific interactions while maintaining privacy and offline functionality.

## Problem Statement
Individuals with early-stage dementia often experience memory decline, confusion, and difficulty recalling familiar information. Existing mobile solutions are typically generic, require internet connectivity, or lack personalisation.

Mynd addresses this gap by providing a personalised, private, and accessible memory support system.

## Key Features 
- User profile setup (name, family members, hobbies, routines)
- Personalised memory prompting system
- AI-generated questions and supportive feedback
- Offline functionality using on-device AI
- Simple and accessible interface for ease of use

## Technology Stack
- Android Studio
- Java (UI and ViewModel layers)
- Google AI Edge SDK (on-device inference)
- Llama 3.2 (quantised model)
- Local storage (for user profile data)

## System Architecture
The application follows a structured architecture combining traditional Android components with on-device AI:

Android UI → ViewModel → Prompt Builder → Llama 3.2 → Response Handler → UI

### Component Breakdown
- UI Layer: Handles user interaction (Activities)
- ViewModel: Manages state and prepares data
- Prompt Builder: Converts user data into structured AI prompts
- Llama Manager: Handles communication with the on-device model
- Response Handler: Formats AI output for display

## AI Integration (Llama 3.2)
Llama 3.2 is used for:
- Generating personalised memory recall questions
- Rephrasing prompts to reduce repetition
- Producing supportive and simplified responses

### Example Prompt
User name: Greg
Family: Sarah (daughter)  
Hobby: Football

Generate a simple memory question and supportive response.

### Benefits of On-Device AI
- Privacy: No user data leaves the device
- Low latency: Instant responses
- Offline capability: No internet required
- Personalisation: Tailored to user data

## Safety Considerations
- AI responses are restricted to stored personal data
- No medical advice is provided
- Harmful or confusing outputs are filtered
- Fallback messages encourage caregiver assistance when needed

## Current Status
This project is currently in the early development phase. 

## LLM Usage Declaration
This project was developed with assistance from ChatGPT for structuring and refining documentation.
