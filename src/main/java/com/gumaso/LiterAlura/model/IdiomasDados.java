package com.gumaso.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IdiomasDados(
        String en, // English
        String pt, // Portuguese
        String fr, // French
        String it, // Italian
        String es, // Spanish
        String de, // German
        String zh, // Chinese
        String ja, // Japanese
        String ru, // Russian
        String ar, // Arabic
        String ko, // Korean
        String hi, // Hindi
        String he, // Hebrew
        String nl, // Dutch
        String sv, // Swedish
        String no, // Norwegian
        String da, // Danish
        String fi, // Finnish
        String pl, // Polish
        String tr  // Turkish
){};