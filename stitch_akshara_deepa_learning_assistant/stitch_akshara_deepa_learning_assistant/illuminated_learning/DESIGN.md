---
name: Illuminated Learning
colors:
  surface: '#f8f9ff'
  surface-dim: '#cbdbf5'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eff4ff'
  surface-container: '#e5eeff'
  surface-container-high: '#dce9ff'
  surface-container-highest: '#d3e4fe'
  on-surface: '#0b1c30'
  on-surface-variant: '#444653'
  inverse-surface: '#213145'
  inverse-on-surface: '#eaf1ff'
  outline: '#757684'
  outline-variant: '#c4c5d5'
  surface-tint: '#3755c3'
  primary: '#00288e'
  on-primary: '#ffffff'
  primary-container: '#1e40af'
  on-primary-container: '#a8b8ff'
  inverse-primary: '#b8c4ff'
  secondary: '#006d30'
  on-secondary: '#ffffff'
  secondary-container: '#92f5a4'
  on-secondary-container: '#007233'
  tertiary: '#003853'
  on-tertiary: '#ffffff'
  tertiary-container: '#005074'
  on-tertiary-container: '#68c4ff'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#dde1ff'
  primary-fixed-dim: '#b8c4ff'
  on-primary-fixed: '#001453'
  on-primary-fixed-variant: '#173bab'
  secondary-fixed: '#95f8a7'
  secondary-fixed-dim: '#79db8d'
  on-secondary-fixed: '#00210a'
  on-secondary-fixed-variant: '#005323'
  tertiary-fixed: '#c9e6ff'
  tertiary-fixed-dim: '#89ceff'
  on-tertiary-fixed: '#001e2f'
  on-tertiary-fixed-variant: '#004c6e'
  background: '#f8f9ff'
  on-background: '#0b1c30'
  surface-variant: '#d3e4fe'
typography:
  headline-lg:
    fontFamily: Inter
    fontSize: 30px
    fontWeight: '700'
    lineHeight: 38px
    letterSpacing: -0.02em
  headline-lg-mobile:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '700'
    lineHeight: 32px
  headline-md:
    fontFamily: Inter
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
  label-lg:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.01em
  label-md:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  base: 8px
  margin-mobile: 20px
  gutter-mobile: 16px
  touch-target-min: 48px
  stack-sm: 12px
  stack-md: 24px
  stack-lg: 40px
---

## Brand & Style

This design system is built on the principles of clarity, encouragement, and accessibility, specifically tailored for 10th-grade students. The brand personality is "The Quiet Guide"—authoritative yet gentle, removing the anxiety often associated with high-stakes examinations like the SSLC. 

The aesthetic follows a **Minimalist** approach with **Modern Corporate** influences to ensure the interface feels professional and reliable. By prioritizing heavy whitespace and a restricted color palette, the UI minimizes cognitive load, allowing students to focus entirely on the educational content. The visual language uses the metaphor of "Deepa" (light) to guide the user's eye through the learning journey using high-contrast elements and clear focal points.

## Colors

The color strategy focuses on high-legibility and positive reinforcement. 

- **Primary Blue:** A deep, calming educational blue used for primary actions and navigation. It provides a sense of stability and institutional trust.
- **Secondary Green:** A fresh "Success Green" reserved for progress indicators, completed states, and correct answers. It is psychologically associated with growth and achievement.
- **Tertiary Sky:** Used sparingly for interactive hints or informational callouts to distinguish them from primary actions.
- **Neutrals:** A range of cool grays starting from a pure white background to ensure maximum contrast ratios for text readability, exceeding WCAG AA standards.

## Typography

The typography system utilizes **Inter** for its exceptional legibility on low-resolution screens often found in budget mobile devices. 

Key constraints:
- **Scalability:** Body text never drops below 16px to accommodate users with varying visual needs.
- **Hierarchy:** Strong weight differentiation (700 for headlines vs 400 for body) ensures that students can scan page titles and section headers instantly.
- **Line Height:** Generous leading (1.5x for body) is maintained to prevent lines of text from "blurring" together during long reading sessions.

## Layout & Spacing

This design system employs a **Fluid Grid** model optimized for a mobile-first experience. 

- **8pt Grid System:** All dimensions, padding, and margins are multiples of 8px to ensure visual rhythm.
- **Safe Margins:** A 20px outer margin on mobile devices prevents content from feeling cramped near the edges of the screen.
- **Touch Targets:** A strict minimum of 48x48px is enforced for all interactive elements to ensure ease of use for students who may be using the app in various environments (e.g., while commuting).
- **Vertical Rhythm:** Content is organized in "stacks" with clearly defined gaps (12px, 24px, or 40px) to separate logical concepts and prevent visual clutter.

## Elevation & Depth

To maintain a clean and non-anxious environment, the design system avoids heavy shadows and skeuomorphism. Instead, it uses **Tonal Layers** and **Low-Contrast Outlines**:

- **Surface Levels:** The base background is white (#FFFFFF). Cards and containers use a very subtle 1px border (#E2E8F0) rather than a shadow to define their boundaries.
- **Interactive Depth:** Only the primary action buttons utilize a "soft shadow"—a very diffused, low-opacity (10%) blue tint—to provide a subtle affordance that the element is tappable.
- **Focus States:** High-contrast 2px solid borders are used for active input fields or selected multiple-choice options to provide unambiguous feedback.

## Shapes

The shape language is defined as **Rounded (Level 2)**. 

- **Core Elements:** Buttons, input fields, and small components use an 8px (0.5rem) corner radius. This balances the professional "academic" feel with a friendly, approachable softness.
- **Containers:** Large cards and study modules use a 16px (1rem) radius to create a distinct visual "nest" for grouped information.
- **Icons:** Should follow a consistent rounded-cap style to match the UI's geometry.

## Components

### Buttons
- **Primary:** Filled Blue, White Text, 48px height. Solid, bold, and centered.
- **Secondary:** Outlined Green, 48px height. Used for "Submit" or "Next Lesson" to provide clear but secondary emphasis.

### Cards
- **Content Cards:** White background, 1px light gray border, 16px padding. Used for lesson previews and quiz questions.
- **Highlight Cards:** Light Blue tint background (#EFF6FF) with no border for "Did you know?" or "Key Tip" boxes.

### Input Fields & Controls
- **Text Inputs:** 48px height, 1px border. On focus, the border thickens and changes to Primary Blue.
- **Checkboxes/Radios:** Oversized (24x24px) with clear check/bullet marks in the Secondary Green for positive feedback.
- **Progress Indicators:** Thick (8px height) horizontal bars. The track is a light gray, and the fill is the Secondary Green.

### Feedback Elements
- **Success Toasts:** Use the secondary green with white text, appearing at the top of the screen to celebrate completion.
- **Empty States:** Simple, centered illustrations with large typography to guide the student back to the learning path.