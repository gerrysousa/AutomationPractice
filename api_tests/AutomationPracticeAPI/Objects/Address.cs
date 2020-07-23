﻿using System;
using System.Collections.Generic;
using System.Text;

namespace AutomationPracticeAPI.Objects
{
    public class Address
    {
        public string street { get; set; }
        public string suite { get; set; }
        public string city { get; set; }
        public string zipcode { get; set; }
        public Geo geo { get; set; }

    }
}
