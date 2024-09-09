using System;
using System.Collections.Generic;

namespace EmployeeManagementMVC.Models;

public partial class Table
{
    public int Id { get; set; }

    public string Name { get; set; } = null!;

    public string City { get; set; } = null!;

    public string Address { get; set; } = null!;
}
