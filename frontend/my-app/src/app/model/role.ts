export class Role {
  id: number;
  roleName: string;

  static cloneBaseRole(role: Role): Role {
    let clonedRole: Role = new Role();
    clonedRole.id = role.id;
    clonedRole.roleName = role.roleName;
    return clonedRole;
  }
}
